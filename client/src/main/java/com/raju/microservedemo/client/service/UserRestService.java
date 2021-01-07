package com.raju.microservedemo.client.service;

import com.raju.microservedemo.client.model.User;
import com.raju.microservedemo.service.dto.JWTToken;
import com.raju.microservedemo.service.dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class UserRestService extends BaseRestTemplate {


    @Autowired
    private RestTemplate restTemplate;

    public List<User> getUsers() {

        String url = getSERVICE_URL().concat("api/users");
        ResponseEntity<List> forEntity = restTemplate.getForEntity(url, List.class);
        return (List<User>) forEntity.getBody();

    }

    public JWTToken login(LoginRequestDto loginRequestDto) {

        String url = getSERVICE_URL().concat("api/authenticate");
        ResponseEntity<JWTToken> jwtTokenResponseEntity = restTemplate.postForEntity(url, loginRequestDto, JWTToken.class);
        return jwtTokenResponseEntity.getBody();

    }

//    public Optional<User> getUserWithAuthorities() {
//        return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
//    }
}
