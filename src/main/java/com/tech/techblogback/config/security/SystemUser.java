package com.tech.techblogback.config.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class SystemUser extends User {

    private Long id;
    private String email;

    public SystemUser(Long id, String username, String password, boolean enabled, String email,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, true, true, true, authorities);
        this.id = id;
        this.email = email;
    }
}
