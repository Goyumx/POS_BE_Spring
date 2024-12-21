package com.goyum.posBE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goyum.posBE.entity.Stock;

@Service
public interface StockService {
    List<Stock> getAllStocks();
    Stock createStock(Stock stock);
    Stock updateStock(Long id,Stock stock);
    Stock getStockById(Long id);
    void deleteStockById(Long id); 
}
