package com.seba.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seba.curso.springboot.webapp.springboot_web.models.User;
import com.seba.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {

        User user = new User("Sebastian", "Infante");
        UserDto userDto = new UserDto();
        
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot DTO");
        
        return userDto;
    }


    @GetMapping("/list")
    public List<User> list(){
        User user1 = new User("Sebastian", "Infante");
        User user2 = new User("Andres", "Guzman");
        User user3 = new User("Jhon", "Doe");


        List<User> users = Arrays.asList(user1,user2,user3);
        // List<User> users = new ArrayList<>();
        // users.add(user1);
        // users.add(user2);
        // users.add(user3);

        return users;
    }


    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {

        User user = new User("Sebastian", "Infante");

        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo Spring Boot Map");
        body.put("user", user);

        return body;
    }

}
