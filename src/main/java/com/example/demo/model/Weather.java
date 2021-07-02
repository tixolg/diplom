package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@Entity
@Table(name = "WEATHER")
public class Weather {
    private Long id;
    private String weather_state_name;
    private String wind_direction_compass;
    private String created;
    private String applicable_date;
    private Double min_temp;
    private Double max_temp;
    private Double the_temp;
    private Long cityId;

    private Date createdAt = new Date();

    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "city_id")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "WEATHER_SEQ")
    @SequenceGenerator(name = "WEATHER_SEQ", sequenceName = "WEATHER_SEQ", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "WEATHER_STATE_NAME")
    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    @Basic
    @Column(name = "WIND_DIRECTION_COMPASS")
    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    @Basic
    @Column(name = "CREATED")
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Basic
    @Column(name = "APPLICABLE_DATE")
    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    @Basic
    @Column(name = "MIN_TEMP")
    public Double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(Double min_temp) {
        this.min_temp = min_temp;
    }

    @Basic
    @Column(name = "MAX_TEMP")
    public Double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(Double max_temp) {
        this.max_temp = max_temp;
    }

    @Basic
    @Column(name = "THE_TEMP")
    public Double getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(Double the_temp) {
        this.the_temp = the_temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather Weather = (Weather) o;
        return
                Objects.equals(id, Weather.id) &&
                        Objects.equals(weather_state_name, Weather.weather_state_name) &&
                        Objects.equals(wind_direction_compass, Weather.wind_direction_compass) &&
                        Objects.equals(created, Weather.created) &&
                        Objects.equals(applicable_date, Weather.applicable_date) &&
                        Objects.equals(min_temp, Weather.min_temp) &&
                        Objects.equals(max_temp, Weather.max_temp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weather_state_name, wind_direction_compass, created, applicable_date, min_temp, max_temp, the_temp);
    }
}