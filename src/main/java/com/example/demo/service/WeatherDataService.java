package com.example.demo.service;

import com.example.demo.datebase.CustomizedEmployeesCrudRepository;
import com.example.demo.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

/**
 * Service for work with data from a database
 * */
@Service
public class WeatherDataService {

    @Autowired
    private CustomizedEmployeesCrudRepository customizedEmployeesCrudRepository;

    /**
     * Search for weather for a city using the city's ID
     * */
    public List<Weather> findByCityId(Long cityId) {
        Optional<List<Weather>> weatherOptional = customizedEmployeesCrudRepository.findByCityId(cityId);
        return weatherOptional.get();
    }

    /**
     * Save the weather for the city
     * */
    public Weather save(Weather weather){
         return  customizedEmployeesCrudRepository.save(weather);
    }

}
