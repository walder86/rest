package com.example.rest.Controllers;

import com.example.rest.DAO.User;
import com.example.rest.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    //Создание пользователя
    @RequestMapping(value = "/create", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public User createUser(@Valid @RequestBody User user){
        log.info("User create - {}", user);
        return userService.createUser(user);
    }


    //Проверка на существование (на вход идёт объект User с полями логина и пароля, остальные null
    // в случае удачи возвращает пользователя, иначе null)
    @RequestMapping(value = "/login",produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public User getUsers(@RequestBody User user){
        log.info("Get users");
        return userService.getUser(user);
    }

}
