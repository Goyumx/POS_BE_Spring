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
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id,Stock stock) {
        Stock updatingstock = stockRepository.findById(id).orElse(null);
        if(updatingstock!=null){
            updatingstock.setStockName(stock.getStockName());
            updatingstock.setDescription(stock.getDescription());
            return stockRepository.save(updatingstock);
        }
        return null;

    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStockById(Long id) {
        stockRepository.deleteById(id);
    }
    
}
