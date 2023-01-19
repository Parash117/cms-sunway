package com.sunway.cms.service.order;

import com.sunway.cms.dto.order.FoodOrderDto;
import com.sunway.cms.dto.order.OrderRequestDto;
import com.sunway.cms.entity.order.Order;

import java.util.List;

public interface OrderService {

    FoodOrderDto create(OrderRequestDto orderRequestDto);

    List<Order> getAll();

    FoodOrderDto cookOrder(Integer orderId, Integer staffId);

    FoodOrderDto prepareOrder(Integer orderId);

    FoodOrderDto serveOrder(Integer orderId, Integer staffId);




}
