package com.pool.poolBackendSide.repository;

import com.pool.poolBackendSide.entity.Booking;
import org.springframework.data.repository.CrudRepository;


public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
