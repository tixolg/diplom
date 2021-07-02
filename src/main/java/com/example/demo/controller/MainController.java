package com.example.demo.controller;

import com.example.demo.service.ParsingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Response;

@RestController
public class MainController {

    private final ParsingService parsingService;

    public MainController(ParsingService parsingService) {
        this.parsingService = parsingService;
    }

    /**
     * Request weather for city
     */

    @GetMapping("/weather")
    public Response weather(@RequestParam(value = "city_id", defaultValue = "2122265") Long cityId ) {
        return parsingService.getForCityById(cityId);
    }
}