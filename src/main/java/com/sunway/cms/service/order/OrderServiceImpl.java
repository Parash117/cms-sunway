package com.sunway.cms.service.order;

import com.sunway.cms.dto.order.FoodItemOrderDto;
import com.sunway.cms.dto.order.OrderRequestDto;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.entity.order.Order;
import com.sunway.cms.entity.students.Students;
import com.sunway.cms.enums.OrderStatus;
import com.sunway.cms.repo.fooditem.FoodItemRepo;
import com.sunway.cms.repo.order.OrderRepo;
import com.sunway.cms.service.fooditem.FoodItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepo orderRepo;

    private final FoodItemService foodItemService;
    private final FoodItemRepo foodItemRepo;

    public OrderServiceImpl(OrderRepo orderRepo, FoodItemService foodItemService,
                            FoodItemRepo foodItemRepo) {
        this.orderRepo = orderRepo;
        this.foodItemService = foodItemService;
        this.foodItemRepo = foodItemRepo;
    }


    @Override
    public Order create(OrderRequestDto orderRequestDto) {

        Order order = new Order();
        order.setStudents(new Students(orderRequestDto.getStudentId()));
        List<FoodItems> foodItemsList = new ArrayList<>();
        Float price = 0F;
        for (FoodItemOrderDto foodItemsDto : orderRequestDto.getFoodItemOrderList()) {
            FoodItems foodItems = foodItemService.findById(foodItemsDto.getFoodItemId());
            price = Float.sum( price,  foodItems.getPrice() * foodItemsDto.getQuantity());
            foodItemsList.add(foodItems);
        }
        order.setTotalPrice(price);
        order.setOrderStatus(OrderStatus.NOT_SERVED);
        order.setFoodItemsList(foodItemsList);
        order.setOrderDate(new Date());

        order = orderRepo.save(order);
        return order;
    }

    @Override
    public List<Order> getAll() {

        return null;
    }
}
