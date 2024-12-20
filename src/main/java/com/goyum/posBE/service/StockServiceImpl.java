package com.goyum.posBE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goyum.posBE.entity.Stock;
import com.goyum.posBE.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> getAllCategories() {
        return stockRepository.findAll();
    }

    @Override
    public Stock createCategory(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateCategory(Long id,Stock stock) {
        return null;
    }

    @Override
    public Stock getCategoryById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategoryById(Long id) {
        stockRepository.deleteById(id);
    }
    
}
