package com.pool.poolBackendSide.entity;


import java.sql.Date;
import java.sql.Time;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date date ;
    private Time time;
    private int quantity;
    private String userEmail;
    private String custEmail;
    private String swimmingPoolName;
    private Integer pid;
    @ManyToOne
    @JsonIgnore
    private SwimmingPool swimmingPool ;

    @ManyToOne
    @JsonIgnore
    private Customer customer ;
}

