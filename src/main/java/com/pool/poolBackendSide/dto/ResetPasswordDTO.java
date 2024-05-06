package com.pool.poolBackendSide.dto;

import lombok.Data;

@Data
public class ResetPasswordDTO {

    private String email ;
    private String activationCode ;
    private String password ;
}
