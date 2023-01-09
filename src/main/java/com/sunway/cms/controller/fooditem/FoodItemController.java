package com.sunway.cms.controller.fooditem;

import com.sunway.cms.abstracts.BaseController;
import com.sunway.cms.dto.food.FoodItemsDto;
import com.sunway.cms.dto.global.ApiResponse;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.service.fooditem.FoodItemService;
import com.sunway.cms.utils.RestApiPaths;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = RestApiPaths.FoodSection.FOOD_URL)
public class FoodItemController extends BaseController {

    private final FoodItemService foodItemService;


    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
        this.moduleName = "Food Items";
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FoodItemsDto foodItemsDto){
        foodItemsDto = foodItemService.save(foodItemsDto);
        return new ResponseEntity<>(new ApiResponse<>("successfully created "+moduleName,
                true,
                foodItemsDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        ApiResponse<List<FoodItems>> foodItemsDtoApiResponse = new ApiResponse<>("successfully fetched food Item's list",
                true,
                foodItemService.getAll());
        return new ResponseEntity<>(foodItemsDtoApiResponse, HttpStatus.OK);
    }

    @GetMapping("/get-by-short-name/{shortName}")
    public ResponseEntity<?> getByShortName(@PathVariable("shortName") String shortName){
        return new ResponseEntity<>(foodItemService.getByShortName(shortName), HttpStatus.OK);
    }

    @GetMapping("/get-categorized")
    public ResponseEntity<?> getByShortName(){
        return new ResponseEntity<>(new ApiResponse("success", true, foodItemService.getActiveFoodItemsByCategory()), HttpStatus.OK);
    }
}
