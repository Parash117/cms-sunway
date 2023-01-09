package com.sunway.cms.service.fooditem;

import com.sunway.cms.dto.food.FoodItemsDto;
import com.sunway.cms.entity.fooditems.FoodItems;

import java.util.List;
import java.util.Map;

public interface FoodItemService {

    FoodItemsDto save(FoodItemsDto foodItemsDto);

    List<FoodItems> getAll();

    List<FoodItemsDto> getByShortName(String shortName);

    Map<String,  List<FoodItemsDto>> getActiveFoodItemsByCategory();

    List<FoodItems> findByIds(List<Integer> ids);
    FoodItems findById(Integer id);
}
