package com.raju.microservedemo.client.controller;

import com.raju.microservedemo.client.model.User;
import com.raju.microservedemo.client.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<User>> getUserList() {


        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);

    }

}
