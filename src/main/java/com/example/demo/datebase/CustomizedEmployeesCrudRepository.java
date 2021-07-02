package com.example.demo.datebase;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Weather;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;
/**
 * Repository for work with the database
 * through this place we go to the database to get data
 * */
@Repository
public interface CustomizedEmployeesCrudRepository extends CrudRepository<Weather, Long>  {

    Optional<List<Weather>> findByCityId(Long l);
}
