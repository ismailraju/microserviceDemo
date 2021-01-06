package com.raju.microservedemo.service.dto;


import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LoginDto {

    @NotNull
    @Size(min = 2,max = 50)
    private String username;

    @NotNull
    @Size(min = 4 ,max = 100)
    private String password;

    private Boolean rememberMe;
}
