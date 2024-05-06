package com.pool.poolBackendSide.service;


import com.pool.poolBackendSide.entity.AppUser;
import com.pool.poolBackendSide.entity.Customer;
import com.pool.poolBackendSide.repository.CustomerRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepostitory customerRepostitory ;


    public Customer save(Customer customer)
    {
        return customerRepostitory.save(customer);
    }


    public Customer findByAppUser(AppUser appUser)
    {
        return customerRepostitory.findByAppUser(appUser);
    }

}