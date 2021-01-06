package com.raju.microservedemo.client.service;

import com.raju.microservedemo.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class UserService extends BaseRestTemplate {


    @Autowired
    private RestTemplate restTemplate;

    public List<User> getUsers() {

        String url = getSERVICE_URL().concat("/api/users");
        List<User> users = restTemplate.getForObject(url, List.class);
        return users;

    }


//    public Optional<User> getUserWithAuthorities() {
//        return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
//    }
}
