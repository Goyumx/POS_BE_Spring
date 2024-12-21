package com.goyum.posBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goyum.posBE.entity.ItemCategory;
import com.goyum.posBE.service.ItemCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {
    
    @Autowired
    ItemCategoryService itemCategoryService;

    @GetMapping("/category")
    public ResponseEntity<List<ItemCategory>> getAllCategories() {
        List<ItemCategory> itemcategories =itemCategoryService.getAllCategories();
        return ResponseEntity.status(200).body(itemcategories);
    }

    @PostMapping("/category")
    public ResponseEntity<ItemCategory> createCategory(@RequestBody ItemCategory itemcategory){
        ItemCategory createdCategory = itemCategoryService.createCategory(itemcategory);
        return ResponseEntity.status(201).body(createdCategory);
    }

    
    @PutMapping("/category/{categoryId}")
    public ResponseEntity<ItemCategory> putMethodName(@PathVariable Long categoryId, @RequestBody ItemCategory itemcategory) {      
        ItemCategory searchedCategory = itemCategoryService.getCategoryById(categoryId);
        if(searchedCategory!=null){
            searchedCategory.setCategoryName(itemcategory.getCategoryName());
        }
        searchedCategory =itemCategoryService.updateCategory(categoryId, itemcategory);
        return ResponseEntity.status(200).body(searchedCategory);
    }
    
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<String> deleteMethodName(@PathVariable Long categoryId) {
        itemCategoryService.deleteCategoryById(categoryId);      
        return ResponseEntity.status(204).body("Category Deleted");
    }
    
}
