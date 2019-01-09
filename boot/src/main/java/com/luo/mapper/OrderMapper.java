package com.luo.mapper;


import com.luo.model.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> getOrderListByUserId(Integer userId);

    void createOrder(Order order);

}
