package com.goyum.posBE.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goyum.posBE.dto.ItemReqDto;
import com.goyum.posBE.entity.Item;
import com.goyum.posBE.entity.ItemCategory;
import com.goyum.posBE.entity.Stock;
import com.goyum.posBE.service.ItemCategoryService;
import com.goyum.posBE.service.ItemService;
import com.goyum.posBE.service.StockService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    
    @Autowired
    ItemService itemService;

    @Autowired
    ItemCategoryService itemCategoryService;

    @Autowired
    StockService stockService;

    @GetMapping("/item")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.status(200).body(items);
    }

    @PostMapping("/item")
    public ResponseEntity<Item> createItem(@RequestBody ItemReqDto itemReqDto) {
        Item item = new Item();
        
        item.setDescription(itemReqDto.getDescription());
        item.setName(itemReqDto.getName());
        item.setPrice(itemReqDto.getPrice());
        item.setQty(itemReqDto.getQty());

        ItemCategory itemCategory = itemCategoryService.getCategoryById(itemReqDto.getCategoryId());
        item.setItemCategory(itemCategory);

        List<Long> enteredstocks= itemReqDto.getStockIds();
        List<Stock> stocks= new ArrayList<>();
        enteredstocks.forEach(stockIds ->{
            Stock stock = stockService.getStockById(stockIds);

            if(stock!=null){
                stocks.add(stock);                
            }
        });
        item.setStocks(stocks);
        itemService.createItem(item);
        return ResponseEntity.status(201).body(item);
    }

    @PutMapping("item/{itemId}")
    public ResponseEntity<Item> uptdateItem(@PathVariable Long itemId,@RequestBody ItemReqDto itemReqDto) {
        
        Item item = itemService.getItemById(itemId);
        item.setDescription(itemReqDto.getDescription());
        item.setName(itemReqDto.getName());
        item.setPrice(itemReqDto.getPrice());
        item.setQty(itemReqDto.getQty());

        List<Long> enteredstocks= itemReqDto.getStockIds();
        List<Stock> stocks= new ArrayList<>();
        enteredstocks.forEach(stockIds ->{
            Stock stock = stockService.getStockById(stockIds);

            if(stock!=null){
                stocks.add(stock);                
            }
        });
        item.setStocks(stocks);
        itemService.updateItem(itemId, item);
        return ResponseEntity.status(200).body(item);
    }

    @DeleteMapping("/item/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long itemId) {
        itemService.deleteItemById(itemId);
        return ResponseEntity.status(204).body("Item Deleted");
    }
}
