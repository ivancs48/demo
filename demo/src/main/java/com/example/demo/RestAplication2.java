package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class RestAplication2 {

	@GetMapping(value = "/hola", produces = MediaType.APPLICATION_JSON_VALUE)
    String home() {
        return "Hola World!";
    }
}
