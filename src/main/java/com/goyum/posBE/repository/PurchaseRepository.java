package com.goyum.posBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goyum.posBE.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase ,Long>{
    
}
