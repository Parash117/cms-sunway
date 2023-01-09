package com.sunway.cms.controller.foodcategory;
import com.sunway.cms.abstracts.BaseController;
import com.sunway.cms.dto.foodcategory.FoodCategoryDto;
import com.sunway.cms.dto.global.ApiResponse;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.service.foodcategory.FoodCategoryService;
import com.sunway.cms.utils.RestApiPaths;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = RestApiPaths.FoodCategory.FOOD_CATEGORY_URL)
public class CategoryController extends BaseController {

    private final FoodCategoryService foodCategoryService;

    public CategoryController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    // post
    @PostMapping
    public ResponseEntity<FoodCategoryDto> createCategory(@Valid @RequestBody FoodCategoryDto foodCategoryDto){
        FoodCategoryDto createFoodCategory = foodCategoryService.createCategory(foodCategoryDto);
        return new ResponseEntity<FoodCategoryDto>(createFoodCategory, HttpStatus.CREATED);
    }

    //put
    @PutMapping("/{categoryId}")
    public ResponseEntity<FoodCategoryDto> updateCategory(@Valid @RequestBody FoodCategoryDto foodCategoryDto,@PathVariable Integer categoryId){
        FoodCategoryDto updateCategory = foodCategoryService.updateCategory(foodCategoryDto,categoryId);
        return new ResponseEntity<FoodCategoryDto>(updateCategory,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        foodCategoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted",true, null),
                HttpStatus.OK);
    }

    //get one
    @GetMapping("/{catId}")
    public ResponseEntity<?> getCategory(@PathVariable Integer catId){
        FoodCategoryDto foodCategoryDto = foodCategoryService.getCategory(catId);
        return  ResponseEntity.ok(new ApiResponse<>(messageSource.get("get", messageSource.get("categories")), true, foodCategoryDto));
    }

    //get all
    @GetMapping
    public ResponseEntity<?> getCategories(){
        List<FoodCategoryDto> categories = foodCategoryService.getAllCategory();
        return ResponseEntity.ok(new ApiResponse<>(
                messageSource.get("get.all", messageSource.get("categories")), true, categories
        ));
    }

    @GetMapping("/get-food-items")
    public ResponseEntity<?> getFoodItemByCategories(){
        List<FoodItems> categories = foodCategoryService.getFoodItemsByCategory();
        return ResponseEntity.ok(new ApiResponse<>(
                messageSource.get("get.all", messageSource.get("categories")), true, categories
        ));
    }


}