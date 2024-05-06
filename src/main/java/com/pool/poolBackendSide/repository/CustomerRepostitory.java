package com.pool.poolBackendSide.repository;
import com.pool.poolBackendSide.entity.AppUser;
import com.pool.poolBackendSide.entity.Customer;
import org.springframework.data.repository.CrudRepository;



public interface CustomerRepostitory extends CrudRepository<Customer, Integer> {

    Customer findByAppUser(AppUser appUser);
}

