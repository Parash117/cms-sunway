package com.sunway.cms.service.order;

import com.sunway.cms.dto.order.FoodItemOrderDto;
import com.sunway.cms.dto.order.FoodOrderDto;
import com.sunway.cms.dto.order.OrderRequestDto;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.entity.order.OderParticular;
import com.sunway.cms.entity.order.Order;
import com.sunway.cms.entity.staff.Staff;
import com.sunway.cms.entity.students.Students;
import com.sunway.cms.enums.OrderStatus;
import com.sunway.cms.exception.OrderFlowException;
import com.sunway.cms.repo.fooditem.FoodItemRepo;
import com.sunway.cms.repo.order.OrderParticularRepo;
import com.sunway.cms.repo.order.OrderRepo;
import com.sunway.cms.service.fooditem.FoodItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    private final FoodItemService foodItemService;
    private final FoodItemRepo foodItemRepo;

    private final OrderParticularRepo orderParticularRepo;
    public OrderServiceImpl(OrderRepo orderRepo, FoodItemService foodItemService,
                            FoodItemRepo foodItemRepo, OrderParticularRepo orderParticularRepo) {
        this.orderRepo = orderRepo;
        this.foodItemService = foodItemService;
        this.foodItemRepo = foodItemRepo;
        this.orderParticularRepo = orderParticularRepo;
    }


    @Override
    public FoodOrderDto create(OrderRequestDto orderRequestDto) {

        Order order = new Order();
        order.setStudents(new Students(orderRequestDto.getStudentId()));
        List<OderParticular> orderParticular = new ArrayList<>();
        order.setOrderStatus(OrderStatus.NOT_SERVED);
        order.setOrderDate(new Date());
        order = orderRepo.save(order);

        Float price = 0F;
        for (FoodItemOrderDto foodItemsDto : orderRequestDto.getFoodItemOrderList()) {
            FoodItems foodItems = foodItemService.findById(foodItemsDto.getFoodItemId());
            price = Float.sum(price, foodItems.getPrice() * foodItemsDto.getQuantity());

            orderParticular.add(OderParticular.builder()
                            .quantity(foodItemsDto.getQuantity())
                            .foodItems(foodItems)
                            .order(order)
                    .build());
        }
        List<OderParticular> oderParticulars = orderParticularRepo.saveAll(orderParticular);
        order.setOrderParticular(orderParticular);
        order.setTotalPrice(price);
        order = orderRepo.save(order);
        return new FoodOrderDto(order);
    }

    @Override
    public List<Order> getAll() {

        return null;
    }

    @Override
    public FoodOrderDto cookOrder(Integer orderId, Integer staffId) {

        Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("not found"));
        if (order.getOrderStatus().equals(OrderStatus.NOT_SERVED)) {
            order.setOrderStatus(OrderStatus.COOKING);
            order.setCookedBy(new Staff(staffId));
            order = orderRepo.save(order);
            return  new FoodOrderDto(order);
        } else {
            throw new OrderFlowException("Order should be placed first then only can be cooked");
        }

    }

    @Override
    public FoodOrderDto prepareOrder(Integer orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("not found"));
        if (order.getOrderStatus().equals(OrderStatus.COOKING)) {
            order.setOrderStatus(OrderStatus.PREPARED);
            order = orderRepo.save(order);
            return  new FoodOrderDto(order);
        } else {
            throw new OrderFlowException("order is not in regular process");
        }
    }

    @Override
    public FoodOrderDto serveOrder(Integer orderId, Integer staffId) {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("not found"));
        if (order.getOrderStatus().equals(OrderStatus.PREPARED)) {
            order.setOrderStatus(OrderStatus.SERVED);
            order.setServedBy(new Staff(staffId));
            order = orderRepo.save(order);
            return new FoodOrderDto(order);
        } else {
            throw new OrderFlowException("order is not in regular process");
        }
    }
}
