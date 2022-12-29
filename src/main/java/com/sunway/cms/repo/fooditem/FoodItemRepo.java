package com.sunway.cms.repo.fooditem;

import com.sunway.cms.entity.fooditems.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItems, Integer> {

    @Query(nativeQuery = true, value = "select * from food_items fi inner join food_category fc on fc.id = fi.food_category_id where fc.short_name = ?1 ")
    List<FoodItems> findByFoodCategoryShortName(String foodCategoryShortName);

}
