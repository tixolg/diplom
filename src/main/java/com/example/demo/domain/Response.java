package com.example.demo.domain;

import com.example.demo.model.Weather;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Response {

    private List<Weather> consolidated_weather;

    public List<Weather> getConsolidated_weather() {
        return consolidated_weather;
    }

    public void setConsolidated_weather(List<Weather> consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

}
