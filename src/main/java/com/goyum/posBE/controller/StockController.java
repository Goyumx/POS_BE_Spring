package com.goyum.posBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.goyum.posBE.entity.Stock;
import com.goyum.posBE.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")
public class StockController {
    
    @Autowired
    StockService stockService;

    @GetMapping("/stock")
    public ResponseEntity<List<Stock>> saveStock() {
        List<Stock> stocks =stockService.getAllStocks();
        return ResponseEntity.status(200).body(stocks);
    }
    
    @PostMapping("/stock")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {   
        Stock createStock =stockService.createStock(stock);   
        return ResponseEntity.status(201).body(createStock);
    } 

    @PutMapping("path/{stockId}")
    public String putMethodName(@PathVariable Long stockId, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }

    @DeleteMapping("/stock/{stockId}")
    public ResponseEntity<String> deleteStock(@PathVariable Long stocktId) {
        stockService.deleteStockById(stocktId);       
        return ResponseEntity.status(204).body("Stock Deleted");
    }
}
