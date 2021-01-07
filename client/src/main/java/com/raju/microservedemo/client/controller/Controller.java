package com.raju.microservedemo.client.controller;

import com.raju.microservedemo.client.model.User;
import com.raju.microservedemo.client.service.UserRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController

public class Controller {

    @Autowired
private  UserRestService  userRestService;



    @GetMapping("/")

    public ModelAndView welcome() {

        List<User> users = userRestService.getUsers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

}
