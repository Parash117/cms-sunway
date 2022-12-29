package com.sunway.cms.dto.foodcategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodCategoryDto {

    //    @NotEmpty
    private String name;

    private String shortName;

    private Boolean isActive = true;

    //    @NotEmpty
    private String description;
}
