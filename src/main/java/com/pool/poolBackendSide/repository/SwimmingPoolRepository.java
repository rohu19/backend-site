package com.pool.poolBackendSide.repository;

import com.pool.poolBackendSide.entity.Owner;
import com.pool.poolBackendSide.entity.SwimmingPool;
import org.springframework.data.repository.CrudRepository;



public interface SwimmingPoolRepository extends CrudRepository<SwimmingPool, Integer> {

    Iterable<SwimmingPool> findAllByTitleLike(String title);

    Iterable<SwimmingPool> findByOwner(Owner owner);

    Iterable<SwimmingPool> findAllByCityLikeAndStateLikeAndCountryLike(String city, String state, String country);
}