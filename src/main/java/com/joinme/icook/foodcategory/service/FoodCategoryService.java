package com.joinme.icook.foodcategory.service;

import java.util.List;

import com.joinme.icook.foodcategory.model.FoodCategory;

public interface FoodCategoryService {
    public FoodCategory getFoodCategoryById(Long categoryId);
    
    public List<FoodCategory> getAllFoodCategory();
}
