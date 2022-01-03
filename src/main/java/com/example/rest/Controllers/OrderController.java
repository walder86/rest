package com.example.rest.Controllers;


import com.example.rest.DAO.Order;
import com.example.rest.Services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.DoubleStream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    //создание заказа
    @RequestMapping(value = "/create",produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Order createOrder(@Valid @RequestBody Order order){
        log.info("Order create - {}", order);
        return orderService.createOrder(order);
    }

    //отображение всех заказов
    @RequestMapping(produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Order> getOrders(){
        log.info("Get orders");
        return orderService.getOrders();
    }

    //подсчёт выручки всех заказов
    @RequestMapping(value = "/amount", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Double getAmmount(){
        log.info("Get amount");
        return orderService.getSumm();
    }

    //Изменение статуса заказа (На вход идёт объект Order с уже изменённым статусом)
    @RequestMapping(value = "/status",produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Order changeStatus(@RequestBody Order order){
        log.info("Change status - {}", order);
        return orderService.changeStatus(order);
    }

}
