package com.goyum.posBE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goyum.posBE.entity.ItemCategory;
import com.goyum.posBE.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllCategories() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory createCategory(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategory updateCategory(Long id ,ItemCategory itemCategory) {
        ItemCategory exisitinCategory = itemCategoryRepository.findById(id).orElse(null);

        if(exisitinCategory!=null){
            exisitinCategory.setCategoryName(itemCategory.getCategoryName());
            return itemCategoryRepository.save(exisitinCategory);
        }
        return null;
    }

    @Override
    public ItemCategory getCategoryById(Long id) {
        return itemCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategoryById(Long id) {
        itemCategoryRepository.deleteById(id);
    }


    
}
