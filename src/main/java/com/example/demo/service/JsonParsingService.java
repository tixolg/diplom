package com.example.demo.service;

import com.example.demo.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.domain.Response;

import java.util.List;


@Service
public class JsonParsingService implements ParsingService {

    private static final String JSON_CITY_URL = "https://www.metaweather.com/api/location/%s/";


    private final RestTemplate restTemplate;

    private final WeatherDataService weatherDataService;

    public JsonParsingService(RestTemplate restTemplate, WeatherDataService weatherDataService) {
        this.restTemplate = restTemplate;
        this.weatherDataService = weatherDataService;
    }

    /**
     * Search in the weather database for the city. If there is no weather for the city,
     * then go to the weather service and save what we received
     */
    public Response getForCityById(Long cityId) {
        List<Weather> weatherList = weatherDataService.findByCityId(cityId);

        Response response;
        if (weatherList == null || weatherList.size() == 0) {
            response = parse(String.format(JSON_CITY_URL, cityId));
            List<Weather> weatherListToSave = response.getConsolidated_weather();
            for (Weather weather : weatherListToSave) {
                weather.setCityId(cityId);
                weatherDataService.save(weather);
            }
        } else {
            response = new Response();
            response.setConsolidated_weather(weatherList);
        }
        return response;

    }

    /**
     * Parse the data that came from the service with the weather
     */
    @Override
    public Response parse(String url) {
        String string = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(string);
        Response response = null;
        try {
            response = objectMapper.readValue(string, Response.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;
    }
}