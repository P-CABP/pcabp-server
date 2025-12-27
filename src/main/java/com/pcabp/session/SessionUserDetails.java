package com.pcabp.session;

import java.util.Collection;
import java.util.List;

import com.pcabp.core.user.vo.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SessionUserDetails implements UserDetails {

    private String username;

    private String password;

    private List<String> authorityCodes;

    public static SessionUserDetails ofUser(User user) {
        return SessionUserDetails.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorityCodes(user.getAuthorities())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityCodes.stream()
                .map(role -> (GrantedAuthority) () -> role)
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
