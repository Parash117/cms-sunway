package com.sunway.cms.service.foodcategory;

import com.sunway.cms.dto.foodcategory.FoodCategoryDto;
import com.sunway.cms.entity.foodcategory.FoodCategory;

import java.util.List;

public interface FoodCategoryService {

    // create
    FoodCategoryDto createCategory(FoodCategoryDto foodCategoryDto);
    // update
    FoodCategoryDto updateCategory(FoodCategoryDto foodCategoryDto, Integer categoryId);
    // delete
    void deleteCategory(Integer categoryId);
    // get single
    FoodCategoryDto getCategory(Integer categoryId);
    // get all
    List<FoodCategoryDto> getAllCategory();
}
