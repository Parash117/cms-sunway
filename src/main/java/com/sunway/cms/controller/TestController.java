package com.sunway.cms.controller;

import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.enums.VegOrNonVegEnum;
import com.sunway.cms.service.fooditem.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/hello")
    public String helloWorld(@RequestParam("msg") String msg) {
        System.out.println("Hello world is called");
        System.out.println(msg);

        FoodItems foodItems = new FoodItems();
        foodItems.setName("buff momo");
        foodItems.setPrice(100F);
        foodItems.setQuantity(10);
        foodItems.setVegOrNonVeg(VegOrNonVegEnum.NON_VEG);
//        foodItemService.save(foodItems);

        return "Hello World";
    }


}
