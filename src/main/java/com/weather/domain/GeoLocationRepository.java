
package com.weather.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.weather.model.GeoLocation;

@Repository // Mongodb repository for GeoLocation for CRUD operations
public interface GeoLocationRepository extends MongoRepository<GeoLocation, Long> {


}