package com.goyum.posBE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goyum.posBE.entity.Stock;

@Service
public interface StockService {
    List<Stock> getAllCategories();
    Stock createCategory(Stock stock);
    Stock updateCategory(Long id,Stock stock);
    Stock getCategoryById(Long id);
    void deleteCategoryById(Long id); 
}
