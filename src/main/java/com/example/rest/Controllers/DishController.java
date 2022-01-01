package com.example.rest.Controllers;


import com.example.rest.DAO.Dish;
import com.example.rest.Services.DishService;
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
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;

    @RequestMapping(value = "/create",produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Dish createDish(@Valid @RequestBody Dish dish){
        log.info("Dish create - {}", dish);
        return dishService.createDish(dish);
    }

    @RequestMapping(produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Dish> getDishes(){
        log.info("Get dishes");
        return dishService.getDishes();
    }


}
