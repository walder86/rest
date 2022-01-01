package com.example.rest.Services;

import com.example.rest.DAO.Order;
import com.example.rest.Repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> gerOrders(){
        return orderRepository.findAll();
    }
}
