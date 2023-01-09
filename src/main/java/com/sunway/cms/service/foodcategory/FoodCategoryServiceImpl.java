package com.sunway.cms.service.foodcategory;

import com.sunway.cms.dto.foodcategory.FoodCategoryDto;
import com.sunway.cms.entity.foodcategory.FoodCategory;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.exceptions.ResourceNotFoundException;
import com.sunway.cms.repo.foodcategory.FoodCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService{

    @Autowired
    private FoodCategoryRepository foodCategoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FoodCategoryDto createCategory(FoodCategoryDto foodCategoryDto) {
        FoodCategory cat = modelMapper.map(foodCategoryDto,FoodCategory.class);
        List<FoodItems> foodItemsList = new ArrayList<>();

        cat.setFoodItemsList(foodItemsList);

        FoodCategory addedCat = foodCategoryRepo.save(cat);
        return modelMapper.map(addedCat,FoodCategoryDto.class);
    }

    @Override
    public FoodCategoryDto updateCategory(FoodCategoryDto foodCategoryDto, Integer categoryId) {
        FoodCategory cat = foodCategoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        cat.setName(foodCategoryDto.getName());
        cat.setDescription(foodCategoryDto.getDescription() );
        FoodCategory updatedCat = foodCategoryRepo.save(cat);
        return modelMapper.map(updatedCat,FoodCategoryDto.class);

    }

    @Override
    public void deleteCategory(Integer categoryId) {
        FoodCategory cat = foodCategoryRepo.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category","Category Id",categoryId));
        foodCategoryRepo.delete(cat);
    }

    @Override
    public FoodCategoryDto getCategory(Integer categoryId) {
        FoodCategory cat = foodCategoryRepo.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category","Category Id",categoryId));
        return modelMapper.map(cat,FoodCategoryDto.class);
    }

    @Override
    public List<FoodCategoryDto> getAllCategory() {
        List<FoodCategory> categories = foodCategoryRepo.findAll();
        List<FoodCategoryDto> catDtos = categories.stream().map((cat)->
                modelMapper.map(cat,FoodCategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }

    @Override
    public List<FoodItems> getFoodItemsByCategory() {
        FoodCategory foodCategory = foodCategoryRepo.findById(1).get();
//        return foodCategory.getFoodItemsList();
        return null;
    }

}
