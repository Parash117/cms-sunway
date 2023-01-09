package com.sunway.cms.service.fooditem;

import com.sunway.cms.dto.food.FoodItemsDto;
import com.sunway.cms.entity.foodcategory.FoodCategory;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.repo.foodcategory.FoodCategoryRepository;
import com.sunway.cms.repo.fooditem.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepo foodItemRepo;

    private final FoodCategoryRepository foodCategoryRepository;

    public FoodItemServiceImpl(FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }

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
        /*List<FoodItems> foodItemsList = foodItemRepo.findByFoodCategoryShortName(shortName);
        List<FoodItemsDto> foodItemsDtoList = new ArrayList<>();
        FoodItemsDto foodItemsDto = new FoodItemsDto();
        for(FoodItems foodItems : foodItemsList){
            foodItemsDtoList.add(foodItemsDto.toDto(foodItems));
        }*/
        List<FoodItemsDto> foodItemsDtoList = foodItemRepo.findByFoodCategoryShortName(shortName).stream()
                .map(x -> new FoodItemsDto().toDto(x))
                .collect(Collectors.toList());
        return foodItemsDtoList;
    }

    @Override
    public Map<String, List<FoodItemsDto>> getActiveFoodItemsByCategory() {
        List<FoodCategory> foodCategoryList = foodCategoryRepository.findAll();

        foodCategoryList = foodCategoryList.stream().filter(x-> x.getIsActive() == true).collect(Collectors.toList());
        Map<String, List<FoodItemsDto>> foodItemsCategorized = new HashMap<>();

//        for(FoodCategory x : foodCategoryList){
//            foodItemsCategorized.put(x.getName(), this.getByShortName(x.getShortName()));
//        }

        List<FoodItems> foodItemsList = foodItemRepo.findAll();

        foodItemsCategorized = foodItemsList.stream().map( x -> new FoodItemsDto().toDto(x) )
                .collect(Collectors.groupingBy(
           cat -> cat.getFoodCategoryShortName()
        ));

        foodCategoryRepository.findAll().parallelStream().forEachOrdered(x -> System.out.println(x.getName()));

        return foodItemsCategorized;
    }

    @Override
    public List<FoodItems> findByIds(List<Integer> ids) {
        return foodItemRepo.findAllById(ids);
    }

    @Override
    public FoodItems findById(Integer id) {
        return foodItemRepo.findById(id).get();
    }
}
