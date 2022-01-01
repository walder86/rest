package com.example.rest.Controllers;


import com.example.rest.DAO.Order;
import com.example.rest.Services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    
    @RequestMapping(value = "/create",produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Order createOrder(@Valid @RequestBody Order order){
        log.info("Order create - {}", order);
        return orderService.createOrder(order);
    }

    @RequestMapping(produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Order> getOrders(){
        log.info("Get orders");
        return orderService.gerOrders();
    }

}
