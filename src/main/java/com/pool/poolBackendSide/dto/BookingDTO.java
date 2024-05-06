package com.pool.poolBackendSide.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;


@Data
public class BookingDTO {

    private String email;
    private Date   date;
    private Integer quantity;
    private Integer poolId;
    private Time    time;
    private Integer id;

}