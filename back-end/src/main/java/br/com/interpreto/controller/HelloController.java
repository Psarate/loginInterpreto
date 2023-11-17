package br.com.interpreto.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*")
public class HelloController {
    //USADO SOMENTE PARA TESTES DA APLICACAO, VERIFICAR SE SUBIU!
    @GetMapping
    public String olaMundo() {
        return "Hello World Spring!";
    }
}
