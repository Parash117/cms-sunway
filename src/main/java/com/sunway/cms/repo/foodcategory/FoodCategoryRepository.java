package com.sunway.cms.repo.foodcategory;

import com.sunway.cms.entity.foodcategory.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {

    @Query(value = "SELECT fc FROM FoodCategory fc WHERE fc.isActive = true")
//    @Query(nativeQuery = true, value = "SELECT * FROM food_category where is_active = true")
    List<FoodCategory> findFoodCategoriesByIsActive(Boolean isActive);

}