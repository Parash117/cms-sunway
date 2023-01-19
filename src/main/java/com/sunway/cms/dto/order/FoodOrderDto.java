package com.sunway.cms.dto.order;

import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.entity.order.Order;
import com.sunway.cms.enums.OrderStatus;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodOrderDto {

    private Integer id;

    private String studentName;

    private String studentRollNum;

    private List<OrderParticular> orderParticulars;

    private Float totalPrice;

    private OrderStatus orderStatus;

    private String cookedBy;


    public FoodOrderDto(Order order) {
        this.id = order.getId();
        this.studentName = order.getStudents().getName();
        this.studentRollNum = order.getStudents().getRollNum();
        this.orderParticulars = order.getOrderParticular().stream().map( x ->
                        OrderParticular.builder()
                                .foodName(x.getFoodItems().getName())
                                .quantity(x.getQuantity())
                                .build()
                )
                .collect(Collectors.toList());
        this.totalPrice = order.getTotalPrice();
        this.orderStatus = order.getOrderStatus();
        this.cookedBy = order.getCookedBy() == null ? null : order.getCookedBy().getName();
    }

}
