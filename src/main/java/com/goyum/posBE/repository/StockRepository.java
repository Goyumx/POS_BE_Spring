package com.goyum.posBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goyum.posBE.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    
}
