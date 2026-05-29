package com.example.university_management.modules.auth.controller;

import com.example.university_management.modules.auth.dto.AuthRequestDTO;
import com.example.university_management.modules.auth.dto.AuthResponseDTO;
import com.example.university_management.modules.auth.dto.RegisterRequestDTO;
import com.example.university_management.modules.auth.entity.Account;
import com.example.university_management.modules.auth.entity.Role;
import com.example.university_management.modules.auth.repository.AccountRepository;
import com.example.university_management.modules.auth.repository.RoleRepository;
import com.example.university_management.modules.auth.security.CustomUserDetails;
import com.example.university_management.modules.auth.utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils,
                          AccountRepository accountRepository, RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> authenticateUser(@Valid @RequestBody AuthRequestDTO loginRequest) {

        // 1. Xác thực tài khoản (Spring Security sẽ tự động gọi CustomUserDetailsService và so sánh mật khẩu BCrypt)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // 2. Nếu không có Exception văng ra -> Xác thực thành công -> Lưu vào Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 3. Lấy thông tin user và tạo Token
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwt = jwtUtils.generateToken(userDetails);

        // 4. Trả Token về cho Client
        return ResponseEntity.ok(new AuthResponseDTO(jwt, "Bearer"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequestDTO registerRequest) {

        // 1. Kiểm tra xem username đã tồn tại chưa
        if (accountRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Lỗi: Username đã tồn tại!");
        }

        // 2. Tìm Role trong Database
        Role role = roleRepository.findByRoleName(registerRequest.getRoleName())
                .orElseThrow(() -> new RuntimeException("Lỗi: Không tìm thấy quyền " + registerRequest.getRoleName()));

        // 3. Tạo tài khoản mới
        Account newAccount = new Account();
        newAccount.setUsername(registerRequest.getUsername());
        // Mã hóa mật khẩu trước khi lưu
        newAccount.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newAccount.setRole(role);

        // 4. Lưu vào Database
        accountRepository.save(newAccount);

        return ResponseEntity.ok("Tạo tài khoản thành công!");
    }
}
