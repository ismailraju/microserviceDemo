/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raju.microservedemo.client.service;

import org.springframework.security.authentication.AuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Asus
 */
public class CustomAuthenticationDetailSource implements AuthenticationDetailsSource {

    @Override
    public Object buildDetails(Object c) {
        String pass = ((HttpServletRequest) c).getParameter("password");
        ((HttpServletRequest) c).getServletContext().setAttribute("password", pass);
        return pass;
    }

}
