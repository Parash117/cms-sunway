package com.sunway.cms.entity.fooditems;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sunway.cms.entity.foodcategory.FoodCategory;
import com.sunway.cms.enums.VegOrNonVegEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "food_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Float price;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private VegOrNonVegEnum vegOrNonVeg;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_category_id",
            foreignKey = @ForeignKey(name = "FK_FOOD_FOOD_CATEGORY"),
            referencedColumnName = "id"
    )
    private FoodCategory foodCategory;

    public FoodItems(Integer id) {
        this.id = id;
    }
}
