
package com.weather.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.weather.model.WeatherForecast;

// mongodb repository for WeatherForecast for CRUD operations
@Repository
public interface WeatherForecastRepository extends MongoRepository<WeatherForecast, Long> {


}