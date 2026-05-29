package com.example.university_management.modules.auth.security;

/**
 * Class này có nhiệm vụ gọi xuống AccountRepository để tìm user,
 * sau đó ném vào CustomUserDetails để trả về cho Spring Security xử lý lúc đăng nhập.
 */

import com.example.university_management.modules.auth.entity.Account;
import com.example.university_management.modules.auth.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public CustomUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + username));

        return new CustomUserDetails(account);
    }
}
