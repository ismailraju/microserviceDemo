package com.raju.microservedemo.client.service;

import com.raju.microservedemo.client.config.security.CustomSpringUser;
import com.raju.microservedemo.service.dto.JWTToken;
import com.raju.microservedemo.service.dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRestService userRestService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ServletContext servletContext;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = "";
        if (servletContext != null) {
            password = (String) servletContext.getAttribute("password");
        }
//        password = "admin";
        LoginRequestDto loginRequestDto = new LoginRequestDto(username, (password), true);
        JWTToken login = userRestService.login(loginRequestDto);
        if (!login.getToken().isEmpty()) {

        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        CustomSpringUser customSpringUser = new CustomSpringUser(username,bCryptPasswordEncoder.encode(password) , grantedAuthorities, login.getToken());
        return customSpringUser;
    }
}
