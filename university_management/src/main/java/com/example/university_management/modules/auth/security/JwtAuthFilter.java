package com.example.university_management.modules.auth.security;

/**
 * Class này sẽ chặn mọi request gửi từ Front-end lên
 * Nó có nhiệm vụ chui vào phần Header của request để tìm xem có chuỗi Token nào không
 * Nếu có và Token hợp lệ, nó sẽ cho phép request đó đi tiếp vào Controller
 */

import com.example.university_management.modules.auth.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthFilter(JwtUtils jwtUtils, CustomUserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        // 1. Lấy thông tin Header mang tên "Authorization"
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;

        // 2. Nếu không có header hoặc không bắt đầu bằng "Bearer ", bỏ qua và đi tiếp (sẽ bị chặn ở SecurityConfig)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. Cắt chữ "Bearer " (7 ký tự đầu) để lấy đúng chuỗi Token
        jwt = authHeader.substring(7);
        username = jwtUtils.extractUsername(jwt);

        // 4. Nếu có username và người dùng chưa được xác thực trong Context
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // 5. Nếu Token hợp lệ thì lưu thông tin xác thực vào Security Context của Spring
            if (jwtUtils.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        // 6. Cho phép request đi tiếp tới Controller
        filterChain.doFilter(request, response);
    }
}
