package com.sunway.cms.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private Long orderId;

    private Long studentId;

    private List<FoodItemOrderDto> foodItemOrderList;

}
