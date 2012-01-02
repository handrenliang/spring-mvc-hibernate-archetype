package com.joinme.icook.foodcategory.DAO.hibernate;

import org.springframework.stereotype.Repository;

import com.joinme.icook.base.BaseDAO;
import com.joinme.icook.foodcategory.DAO.FoodCategoryDAO;
import com.joinme.icook.foodcategory.model.FoodCategory;

@Repository(value="foodCategoryDAO")
public class FoodCategoryDAOImpl extends BaseDAO<FoodCategory, Long> implements
        FoodCategoryDAO {

}
