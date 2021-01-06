package com.raju.microservedemo.service.exception;


import org.springframework.security.core.AuthenticationException;

public class UserNotActivatedException extends AuthenticationException {

    private static final long serialVersionUID = -1126699074574529145L;

    public UserNotActivatedException(String message) {
        super(message);
    }
}
