package com.pool.poolBackendSide.repository;
import com.pool.poolBackendSide.entity.AppUser;
import com.pool.poolBackendSide.entity.Owner;
import org.springframework.data.repository.CrudRepository;



public interface OwnerRepository extends CrudRepository<Owner, Integer>{

    Owner findByAppUser(AppUser appUser) ;
}

