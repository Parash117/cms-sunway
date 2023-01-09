package com.sunway.cms.controller.order;

import com.sunway.cms.abstracts.BaseController;
import com.sunway.cms.dto.food.FoodItemsDto;
import com.sunway.cms.dto.global.ApiResponse;
import com.sunway.cms.dto.order.OrderRequestDto;
import com.sunway.cms.entity.order.Order;
import com.sunway.cms.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequestDto orderRequestDto){
        Order order = orderService.create(orderRequestDto);
        return new ResponseEntity<>(new ApiResponse<>("successfully created "+moduleName,
                true,
                order), HttpStatus.CREATED);
    }
}
