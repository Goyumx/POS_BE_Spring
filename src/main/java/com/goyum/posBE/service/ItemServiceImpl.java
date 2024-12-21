package com.goyum.posBE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goyum.posBE.entity.Item;
import com.goyum.posBE.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id,Item item) {
        Item exsitingItem =itemRepository.findById(id).orElse(null);

        if(exsitingItem!=null){
            exsitingItem.setName(item.getName());
            exsitingItem.setPrice(item.getPrice());
            exsitingItem.setQty(item.getQty());
            exsitingItem.setStocks(item.getStocks());
            exsitingItem.setDescription(item.getDescription());
            exsitingItem.setItemCategory(item.getItemCategory());
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
    
}
