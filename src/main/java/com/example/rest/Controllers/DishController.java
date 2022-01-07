package com.example.rest.Controllers;


import com.example.rest.DAO.Dish;
import com.example.rest.Services.DishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;


    //Создание блюда
    @RequestMapping(value = "/create",produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Dish createDish(@Valid @RequestBody Dish dish){
        log.info("Dish create - {}", dish.getName());
        return dishService.createDish(dish);
    }

    //Отображение всех блюд
    @RequestMapping(produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Dish> getDishes(){
        log.info("Get dishes");
        return dishService.getDishes();
    }

    //Отображение одного блюда по его ID
    @RequestMapping(path = "/getById/{id}", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Optional<Dish> getDish(@PathVariable Integer id){
        return dishService.getDishById(id);
    }

    //Изменение поля in_menu для составление меню (на вход идёт объект Dish, с уже изменённым полем in_menu)
    @RequestMapping(value = "/menu", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Dish changeInMenu(@RequestBody Dish dish){
        return dishService.menu(dish);
    }


}
