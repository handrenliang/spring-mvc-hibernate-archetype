package com.joinme.icook.category;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.joinme.icook.base.TestBase;
import com.joinme.icook.foodcategory.service.FoodCategoryService;

public class TestFoodCategoryService extends
        TestBase {
    @Autowired
    private FoodCategoryService foodCategoryService;

    @Test
    public void getFoodCategoryById() {
        foodCategoryService.getFoodCategoryById(1L);
    }
}
