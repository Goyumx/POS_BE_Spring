package com.goyum.posBE.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ItemId;
    
    @Column(nullable = false)
    private String name;

    private Double price;

    private int qty;

    private String description;
    
    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private ItemCategory itemCategory;

    @ManyToMany
    @JoinTable(
        name = "stock_item",
        joinColumns = @JoinColumn(name = "stockId"),
        inverseJoinColumns = @JoinColumn(name = "itemId"))
    private List<Stock> stocks;
}
