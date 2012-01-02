package com.joinme.icook.foodcategory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joinme.icook.foodcategory.DAO.FoodCategoryDAO;
import com.joinme.icook.foodcategory.model.FoodCategory;
import com.joinme.icook.foodcategory.service.FoodCategoryService;

@Service(value = "foodCategoryService")
public class FoodCategoryServiceImpl implements FoodCategoryService {
    @Autowired
    private FoodCategoryDAO foodCategoryDAO;

    @Override
    public FoodCategory getFoodCategoryById(Long categoryId) {
        return foodCategoryDAO.find(categoryId);
    }

    @Override
    public List<FoodCategory> getAllFoodCategory() {
        return foodCategoryDAO.findAll();
    }

    public FoodCategoryDAO getFoodCategoryDAO() {
        return foodCategoryDAO;
    }

    public void setFoodCategoryDAO(FoodCategoryDAO foodCategoryDAO) {
        this.foodCategoryDAO = foodCategoryDAO;
    }
}
