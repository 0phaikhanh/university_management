package com.example.university_management.modules.auth.security;

/**
 * Đây là trung tâm điều khiển của Spring Security.
 * Tại đây, ta sẽ khai báo tắt/mở các API,
 * khai báo thuật toán băm mật khẩu (BCrypt)
 * và chèn cái JwtAuthFilter ở trên vào quy trình kiểm tra.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Cho phép phân quyền bằng Annotation (@PreAuthorize) ở Controller
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter, CustomUserDetailsService userDetailsService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Tắt CSRF vì chúng ta dùng Token (Stateless)
                .authorizeHttpRequests(auth -> auth
                        // Mở cửa tự do cho các API đăng nhập và tài liệu Swagger
                        .requestMatchers("/api/auth/**", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        // Tất cả các API khác (như CRUD học phí, điểm số...) đều bắt buộc phải có Token hợp lệ
                        .anyRequest().authenticated()
                )
                // Không dùng Session của server để lưu trạng thái đăng nhập
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Cấu hình AuthenticationProvider
                .authenticationProvider(authenticationProvider())
                // Chèn bộ lọc kiểm tra JWT vào trước bộ lọc kiểm tra Username/Password mặc định
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Bean dùng để băm và kiểm tra mật khẩu (BCrypt là chuẩn hiện nay)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Cung cấp thông tin User và cách mã hóa cho Spring Security
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Quản lý việc xác thực (dùng trong AuthController để gọi hàm đăng nhập)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
