package com.sunway.cms.service.fooditem;

import com.sunway.cms.dto.food.FoodItemsDto;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.repo.fooditem.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepo foodItemRepo;


    @Override
    public FoodItemsDto save(FoodItemsDto foodItemsDto) {
        FoodItems foodItemsToBeSaved = foodItemsDto.toEntity(foodItemsDto);
        FoodItems foodItems = foodItemRepo.save(foodItemsToBeSaved);
        return new FoodItemsDto().toDto(foodItems);
    }

    @Override
    public List<FoodItems> getAll() {
        List<FoodItems> foodItemsList = foodItemRepo.findAll();
        List<FoodItemsDto> foodItemsDtoList = new ArrayList<>();
        FoodItemsDto foodItemsDto = new FoodItemsDto();
        for(FoodItems foodItems : foodItemsList){
            foodItemsDtoList.add(foodItemsDto.toDto(foodItems));
        }

        return foodItemsList;
    }

    @Override
    public List<FoodItemsDto> getByShortName(String shortName) {
        List<FoodItems> foodItemsList = foodItemRepo.findByFoodCategoryShortName(shortName);
        List<FoodItemsDto> foodItemsDtoList = new ArrayList<>();
        FoodItemsDto foodItemsDto = new FoodItemsDto();
        for(FoodItems foodItems : foodItemsList){
            foodItemsDtoList.add(foodItemsDto.toDto(foodItems));
        }

        return foodItemsDtoList;
    }

}
