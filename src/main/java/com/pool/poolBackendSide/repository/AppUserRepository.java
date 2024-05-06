package com.pool.poolBackendSide.repository;

import com.pool.poolBackendSide.entity.AppUser;
import org.springframework.data.repository.CrudRepository;


public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByEmail(String email) ;

    AppUser findByEmailAndPassword(String email , String password) ;

}