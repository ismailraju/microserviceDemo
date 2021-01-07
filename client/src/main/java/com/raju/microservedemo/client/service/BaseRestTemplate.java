package com.raju.microservedemo.client.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component

@Getter

public class BaseRestTemplate {


    @Value("${service.protocol}")
    private  String PROTOCOL;

    @Value("${service.host}")
    public  String HOST;

    @Value("${service.port}")
    public  String PORT;

    @Value("${service.context-path}")
    public  String PATH;

    @Getter
    public  String SERVICE_URL = "";

    @PostConstruct
    void init() {


        if (PORT != null && PORT.length() > 0) {
            SERVICE_URL = PROTOCOL + "://" + HOST + ":" + PORT + "/" + PATH;
        } else {
            SERVICE_URL = PROTOCOL + "://" + HOST + "/" + PATH;
        }
    }

//
//    public static String getToken() {
//        try {
//            ApplicationUser cUser = (ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            if (cUser != null) {
//                return cUser.getToken();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return "";
//    }
}
