package com.example.demo.service;

import com.example.demo.domain.Response;

public interface ParsingService {

    /**
     * Service to parse the Json response and convert it to
     * the desired model class
     */

    Response parse(String url);
    Response getForCityById(Long id);
}
