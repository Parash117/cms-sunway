package com.sunway.cms.entity.foodcategory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sunway.cms.entity.fooditems.FoodItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "food_category", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_FOOD_CAT_NAME", columnNames = {"name", "shortName"})
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String shortName;

    private Boolean isActive;

    @Column(columnDefinition = "TEXT")
    private String Description;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodCategory")
    private List<FoodItems> foodItemsList;

    public FoodCategory(Integer id){
        this.id = id;
    }

}
