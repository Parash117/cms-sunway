package com.sunway.cms.entity.order;

import com.sunway.cms.entity.fooditems.FoodItems;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_particular")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OderParticular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "food_item_id", foreignKey = @ForeignKey(name = "FK_ORDERPARTICULAR_FOODITEMS"))
    private FoodItems foodItems;

    @ManyToOne
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "FK_ORDERPARTICULAR_orders"))
    private Order order;

    private Integer quantity;

}
