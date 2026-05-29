package com.example.university_management.modules.auth.security;

/**
 * Spring Security yêu cầu đối tượng người dùng phải implement interface UserDetails.
 * Class này sẽ đóng gói entity Account của ta thành dạng mà Spring Security hiểu được
 */

import com.example.university_management.modules.auth.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Account account;

    public CustomUserDetails(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Lấy tên quyền (Ví dụ: ROLE_ADMIN) từ entity Role và chuyển thành GrantedAuthority
        return Collections.singleton(new SimpleGrantedAuthority(account.getRole().getRoleName()));
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    // Các hàm dưới đây tạm thời cho return true (mặc định tài khoản luôn hoạt động)
    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return true; }
}
