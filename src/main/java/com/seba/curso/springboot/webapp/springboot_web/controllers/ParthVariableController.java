package com.seba.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.seba.curso.springboot.webapp.springboot_web.models.User;
import com.seba.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/var")
public class ParthVariableController {

    @Value("${config.code}")
    private Integer code;
    @Value("${config.username}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.listOfValues}")
    private String[] listOfValues;
    @Value("#{${config.valuesMap}.price}")
    private Long price;
    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Autowired
    Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
        // http:// localhost:8080/api/var/baz/hola
        // {
        // "message": "hola",
        // "code": null
        // }
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
        // http:// localhost:8080/api/var/mix/libro/1
        // {
        // "product": "libro",
        // "id": 1
        // }
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // En este punto el User que llega desde la petición, debe ser guardada en bbdd o similar. 
        return user;
    }
    

    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("price", price);
        json.put("product", product);
        json.put("code2", environment.getProperty("config.code", Long.class));
        return json;
    }
    

}
