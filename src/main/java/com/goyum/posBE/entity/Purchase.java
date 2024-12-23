package com.goyum.posBE.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDateTime;
    private Double totalPrice;


    @PrePersist 
    protected void onCreate() {
        if(this.orderDateTime == null) {
            this.orderDateTime = LocalDateTime.now();
        }
    }

    @ManyToMany
    @JoinTable(
        name="purchased_items",
        joinColumns = @JoinColumn(name="purchaseId"),
        inverseJoinColumns = @JoinColumn(name="itemId")
    )
    private List<Item> purchasedItems;
}
