package com.goyum.posBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goyum.posBE.entity.ItemCategory;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
    
}
