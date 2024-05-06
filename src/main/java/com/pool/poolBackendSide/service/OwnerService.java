package com.pool.poolBackendSide.service;

import com.pool.poolBackendSide.entity.Owner;
import com.pool.poolBackendSide.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository ;

    public Owner save(Owner owner)
    {
        return ownerRepository.save(owner) ;
    }


}
