package com.raju.microservedemo.client.config;

import com.raju.microservedemo.client.config.security.CustomSpringUser;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class AuthorizationHeaderInterceptor implements org.springframework.http.client.ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        ClientHttpResponse clientHttpResponse = null;

        String token = "";

        if (SecurityContextHolder.getContext() != null &&
                SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {


            CustomSpringUser principal = (CustomSpringUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null) {
                token = principal.getToken();
            }
        }

        httpRequest.getHeaders().add(Variables.AUTHORIZATION_HEADER, "Bearer " + token);

        return clientHttpRequestExecution.execute(httpRequest, bytes);


    }
}
