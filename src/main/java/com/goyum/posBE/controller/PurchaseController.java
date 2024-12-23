package com.goyum.posBE.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.goyum.posBE.dto.PurchaseDto;
import com.goyum.posBE.entity.Item;
import com.goyum.posBE.entity.Purchase;
import com.goyum.posBE.service.ItemService;
import com.goyum.posBE.service.PurchaseService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@CrossOrigin(origins = "*")
public class PurchaseController {
    
    @Autowired
    PurchaseService purchaseService;

    @Autowired
    ItemService itemService;

    @GetMapping("/purchase")
    public ResponseEntity<List<Purchase>> getMethodName() {
        List<Purchase> purchase = purchaseService.getAllPurchases();
        return ResponseEntity.status(200).body(purchase);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Purchase> postMethodName(@RequestBody PurchaseDto purchaseDto) {
        Purchase purchase = new Purchase();
        purchase.setTotalPrice(0.0);
        System.out.println(purchaseDto.getPurchased_items());
        List<Long> purchasedItemIds =purchaseDto.getPurchased_items();
        List<Item> purchItems =new ArrayList<>();

        for (Long ids : purchasedItemIds) {
            Item item = itemService.getItemById(ids);
            if(item!=null){
                purchItems.add(item);
                purchase.setTotalPrice(purchase.getTotalPrice()+item.getPrice());
            }
        }

        purchase.setPurchasedItems(purchItems);
        purchaseService.createPurchase(purchase);
        return ResponseEntity.status(200).body(purchase);
    }
}
