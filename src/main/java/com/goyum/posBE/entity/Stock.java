package com.goyum.posBE.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;
    
    @Column(nullable = false)
    private String stockName;

    private String description;


    @JsonIgnore
    @ManyToMany(mappedBy = "stocks")
    private List<Item> items;
   
}
