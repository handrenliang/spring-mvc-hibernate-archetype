package com.joinme.icook.foodcategory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joinme.icook.foodcategory.service.FoodCategoryService;

@Controller
@RequestMapping("/category")
public class FoodCategoryController {
    @Autowired
    private FoodCategoryService foodCategoryService;

    @RequestMapping("")
    public String getAllFoodCategory(ModelMap modelMap) {
        modelMap.addAttribute("categories", foodCategoryService
                .getAllFoodCategory());
        return "category/details";
    }
    
    @RequestMapping("/{categoryId}")
    public String getFoodCategoryById(@PathVariable("categoryId") Long categoryId, ModelMap modelMap) {
        modelMap.addAttribute("category", foodCategoryService.getFoodCategoryById(categoryId));
        return "category/details";
    }
    
    public FoodCategoryService getFoodCategoryService() {
        return foodCategoryService;
    }

    public void setFoodCategoryService(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }
}
