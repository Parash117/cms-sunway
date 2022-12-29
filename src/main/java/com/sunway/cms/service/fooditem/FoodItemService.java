package com.sunway.cms.service.fooditem;

import com.sunway.cms.dto.food.FoodItemsDto;
import com.sunway.cms.entity.fooditems.FoodItems;

import java.util.List;

public interface FoodItemService {

    FoodItemsDto save(FoodItemsDto foodItemsDto);

    List<FoodItems> getAll();

    List<FoodItemsDto> getByShortName(String shortName);
}
