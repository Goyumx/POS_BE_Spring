package com.goyum.posBE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goyum.posBE.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllCategories();
    ItemCategory createCategory(ItemCategory itemCategory);
    ItemCategory updateCategory(Long id ,ItemCategory itemCategory);
    ItemCategory getCategoryById(Long id);
    void deleteCategoryById(Long id); 
}
