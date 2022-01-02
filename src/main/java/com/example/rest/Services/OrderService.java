package com.example.rest.Services;

import com.example.rest.DAO.Order;
import com.example.rest.Repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.DoubleStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public DoubleStream getSumm(){
        return orderRepository.findAll().stream()
                .mapToDouble(Order::getAmount);
    }

    public Order changeStatus(Order order){
        Order order1 = orderRepository.findAll().stream().filter(o -> o.getId().equals(order.getId()))
                .findFirst().get();
        order1.setStatus(order.getStatus());
        return orderRepository.save(order1);
    }
}
