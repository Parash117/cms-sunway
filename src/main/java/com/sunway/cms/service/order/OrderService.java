package com.sunway.cms.service.order;

import com.sunway.cms.dto.order.OrderRequestDto;
import com.sunway.cms.entity.order.Order;

import java.util.List;

public interface OrderService {

    Order create(OrderRequestDto orderRequestDto);

    List<Order> getAll();

}
