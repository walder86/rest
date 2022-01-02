package com.example.rest.Services;

import com.example.rest.DAO.Dish;
import com.example.rest.Repositories.DishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public Dish createDish(Dish dish){
        return dishRepository.save(dish);
    }

    public List<Dish> getDishes(){
        return dishRepository.findAll();
    }

    public Dish menu(Dish dish){
        Dish dish1 = dishRepository.findByName(dish.getName());
        dish1.setInMenu(dish.getInMenu());
        return dishRepository.save(dish1);
    }
}
