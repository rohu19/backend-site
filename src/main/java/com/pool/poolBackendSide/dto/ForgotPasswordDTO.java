package com.pool.poolBackendSide.dto;

import lombok.Data;

@Data
public class ForgotPasswordDTO {

    private String email ;
    private String message ;
    private boolean status ;

}
