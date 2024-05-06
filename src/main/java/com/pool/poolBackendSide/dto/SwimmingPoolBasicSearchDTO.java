package com.pool.poolBackendSide.dto;

import com.pool.poolBackendSide.entity.SwimmingPool;
import lombok.Data;

@Data
public class SwimmingPoolBasicSearchDTO {
    private boolean status;
    private String message;

    private Iterable<SwimmingPool> pools;
}