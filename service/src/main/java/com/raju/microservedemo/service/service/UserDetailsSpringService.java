package com.raju.microservedemo.service.service;

import com.raju.microservedemo.service.exception.UserNotActivatedException;
import com.raju.microservedemo.service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class UserDetailsSpringService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsSpringService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowercaseUsername = username.toLowerCase(Locale.ENGLISH);
        return userRepository.findOneWithAuthoritiesByUsername(lowercaseUsername)
                .map(user -> createSpringSecurityUser(lowercaseUsername, user))
                .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseUsername + " was not found in the database"));

    }

    private User createSpringSecurityUser(String lowercaseUsername, com.raju.microservedemo.service.model.User user) {
        if (!user.isActivated()) {
            throw new UserNotActivatedException("User " + lowercaseUsername + " was not activated");
        }

        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(grantedAuthority -> new SimpleGrantedAuthority(grantedAuthority.getName()))
                .collect(Collectors.toList());
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
