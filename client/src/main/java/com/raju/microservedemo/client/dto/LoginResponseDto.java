package com.raju.microservedemo.client.dto;

import com.raju.microservedemo.client.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class LoginResponseDto extends BaseResponse {
    private User user;

    public LoginResponseDto(boolean success, String message) {
        super(success, message);
    }
}
