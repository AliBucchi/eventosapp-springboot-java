package com.eventoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")  //faz o mapeamento de uma solicitação HTTP para um método em um controlador.
    public String index() {
        return "index";
    }
}
