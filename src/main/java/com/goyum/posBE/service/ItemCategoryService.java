package com.goyum.posBE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goyum.posBE.dto.ItemCategoryDto;
import com.goyum.posBE.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllCategories();
    ItemCategory createCategory(ItemCategory itemCategory);
    ItemCategory updateCategory(Long categoryId, ItemCategoryDto itemcategory);
    ItemCategory getCategoryById(Long id);
    void deleteCategoryById(Long id); 
}
