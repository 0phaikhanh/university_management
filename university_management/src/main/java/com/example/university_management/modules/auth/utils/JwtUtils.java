package com.example.university_management.modules.auth.utils;

/**
 * Class này chuyên dùng để tạo token khi đăng nhập thành công
 * và xác thực token mỗi khi Front-end gửi request lên
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {

    // Khóa bí mật dùng để mã hóa Token (Độ dài tối thiểu 32 ký tự).
    // Trong thực tế, chuỗi này nên để trong file application.properties
    private final String SECRET_STRING = "DayLaChuoiBaoMatCuaTruongDaiHocHUBT2026";
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));

    // Thời gian sống của Token: 24 giờ (tính bằng milliseconds)
    private final long EXPIRATION_TIME = 86400000L;

    // 1. Tạo JWT Token từ thông tin UserDetails
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    // 2. Lấy Username từ JWT Token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 3. Kiểm tra Token có hợp lệ với UserDetails không
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claimsResolver.apply(claims);
    }
}
