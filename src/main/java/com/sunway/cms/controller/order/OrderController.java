package com.sunway.cms.controller.order;

import com.sunway.cms.abstracts.BaseController;
import com.sunway.cms.dto.food.FoodItemsDto;
import com.sunway.cms.dto.global.ApiResponse;
import com.sunway.cms.dto.order.FoodOrderDto;
import com.sunway.cms.dto.order.OrderRequestDto;
import com.sunway.cms.entity.order.Order;
import com.sunway.cms.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequestDto orderRequestDto){
        FoodOrderDto order = orderService.create(orderRequestDto);
        return new ResponseEntity<>(new ApiResponse<>("successfully created "+moduleName,
                true,
                order), HttpStatus.CREATED);
    }

    @GetMapping("/cook-order/order-id/{orderId}/staff-id/{staffId}")
    public ResponseEntity<?> cookOrder(@PathVariable("orderId") Integer orderId, @PathVariable("staffId") Integer staffId){
        FoodOrderDto order = orderService.cookOrder(orderId, staffId);
        return new ResponseEntity<>(new ApiResponse<>("successfully created "+moduleName,
                true,
                order), HttpStatus.OK);
    }

    @GetMapping("/prepare-order/order-id/{orderId}")
    public ResponseEntity<?> prepareOrder(@PathVariable("orderId") Integer orderId){
        FoodOrderDto order = orderService.prepareOrder(orderId);
        return new ResponseEntity<>(new ApiResponse<>("successfully created "+moduleName,
                true,
                order), HttpStatus.OK);
    }

    @GetMapping("/serve-order/order-id/{orderId}/staff-id/{staffId}")
    public ResponseEntity<?> serveOrder(@PathVariable("orderId") Integer orderId, @PathVariable("staffId") Integer staffId){
        FoodOrderDto order = orderService.serveOrder(orderId, staffId);
        return new ResponseEntity<>(new ApiResponse<>("successfully created "+moduleName,
                true,
                order), HttpStatus.OK);
    }
}
