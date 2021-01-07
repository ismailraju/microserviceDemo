package com.raju.microservedemo.client.config.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


@Getter
@Setter

public class CustomSpringUser extends User {

    String token;

    public CustomSpringUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String token) {
        super(username, password, authorities);
        this.token = token;
    }
}
