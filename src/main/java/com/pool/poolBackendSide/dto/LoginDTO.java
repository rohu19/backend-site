package com.pool.poolBackendSide.dto;


import lombok.Data;

@Data
public class LoginDTO {

    private String username ;
    private String password ;
    private String role ;
    private String status ;

}
