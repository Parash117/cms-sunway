package com.sunway.cms.dto.food;

import com.sunway.cms.entity.foodcategory.FoodCategory;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.enums.VegOrNonVegEnum;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodItemsDto {

    private Integer id;

    private String name;

    private Float price;

    private Integer quantity;

    private VegOrNonVegEnum vegOrNonVeg;

    private Integer foodCategoryId;

    private String foodCategoryName;

    private String foodCategoryShortName;

    public FoodItemsDto toDto(FoodItems foodItems){
        FoodItemsDto foodItemsDto = FoodItemsDto.builder()
                .id(foodItems.getId())
                .name(foodItems.getName())
                .foodCategoryId(foodItems.getFoodCategory().getId())
                .price(foodItems.getPrice())
                .quantity(foodItems.getQuantity())
                .vegOrNonVeg(foodItems.getVegOrNonVeg())
                .foodCategoryName(foodItems.getFoodCategory().getName())
                .foodCategoryShortName(foodItems.getFoodCategory().getShortName())
                .build();
        return foodItemsDto;
    }

    public FoodItems toEntity(FoodItemsDto foodItemsDto){
        FoodItems foodItemsToBeSaved = new FoodItems();
        foodItemsToBeSaved.setId(foodItemsDto.getId());
        foodItemsToBeSaved.setName(foodItemsDto.getName());
        foodItemsToBeSaved.setVegOrNonVeg(foodItemsDto.getVegOrNonVeg());
        foodItemsToBeSaved.setQuantity(foodItemsDto.getQuantity());
        foodItemsToBeSaved.setPrice(foodItemsDto.getPrice());
        foodItemsToBeSaved.setFoodCategory(new FoodCategory(foodItemsDto.getFoodCategoryId()));
        return foodItemsToBeSaved;
    }

}
