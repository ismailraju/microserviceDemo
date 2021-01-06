package com.raju.microservedemo.service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JWTToken {

    String token;
}
