package com.example.rest.Services;

import com.example.rest.DAO.Order;
import com.example.rest.Repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<Order> getOrder(Integer integer){
        return orderRepository.findById(integer);
    }

    public List<Integer> getIdOrders(){
        return orderRepository.findAll().stream().mapToInt(Order :: getId).boxed().collect(Collectors.toList());
    }

    public Double getSumm(){
        Date date = new Date();
        int sum = 0;
        log.info(String.valueOf(orderRepository.findAll().stream().findFirst().get().getDate().getTime()));
        log.info(String.valueOf(date.getTime()));
        return orderRepository.findAll().stream().filter(d -> date.getTime() - d.getDate().getTime()<86400000)
                .mapToDouble(Order::getAmount).sum();
    }

    public Order changeStatus(Order order){
        Order order1 = orderRepository.findAll().stream().filter(o -> o.getId().equals(order.getId()))
                .findFirst().get();
        order1.setStatus(order.getStatus());
        return orderRepository.save(order1);
    }
}
