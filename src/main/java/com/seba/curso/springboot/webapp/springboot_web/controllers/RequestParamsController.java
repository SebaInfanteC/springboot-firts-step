package com.seba.curso.springboot.webapp.springboot_web.controllers;

import com.seba.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Debe ingresar un mensaje") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) {
        // De esta forma no se puede controlar con un tryCatch el code si este viene como string. Ya que va a fallar al momento de recuperar la data
        // Hay que estar seguro de lo que viene para usar este metodo
        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        //De esta forma siempre retorna string, por lo que uno debe manipular la data dependiendo de lo que necesite.
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        ParamDto params = new ParamDto();
        params.setCode(code);
        params.setMessage(request.getParameter("text"));

        return params;
    }

}
