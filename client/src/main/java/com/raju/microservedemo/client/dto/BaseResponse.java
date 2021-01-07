package com.raju.microservedemo.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BaseResponse implements Serializable {
    private boolean success;
    private String message;

}
