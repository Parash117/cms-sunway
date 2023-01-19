package com.sunway.cms.entity.order;

import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.entity.staff.Staff;
import com.sunway.cms.entity.students.Students;
import com.sunway.cms.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "food_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "FK_ORDER_STUDENT"))
    private Students students;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "order_food",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "food_item_id", referencedColumnName = "id")
    )
    private List<FoodItems> foodItemsList;*/

    @OneToMany
    private List<OderParticular> orderParticular;

    private Integer orderNumber;

    private Date orderDate;

    private Float totalPrice;

    // 1 -> 2 -> 3 -> 1
    //           3 -> 4

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "cooked_by", foreignKey = @ForeignKey(name = "FK_COOKEDBY_STUDENT"))
    private Staff cookedBy;

    @ManyToOne
    @JoinColumn(name = "served_by", foreignKey = @ForeignKey(name = "FK_SERVED_STUDENT"))
    private Staff servedBy;


}
