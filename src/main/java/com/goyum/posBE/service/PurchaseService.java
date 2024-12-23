package com.goyum.posBE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goyum.posBE.entity.Purchase;

@Service
public interface PurchaseService {

    List<Purchase> getAllPurchases();
    Purchase createPurchase(Purchase purchase);    
}
