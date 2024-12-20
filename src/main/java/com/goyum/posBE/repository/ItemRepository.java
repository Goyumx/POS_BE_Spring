package com.goyum.posBE.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goyum.posBE.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
