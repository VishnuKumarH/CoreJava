package com.ust.spring.backend_airbook.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.spring.backend_airbook.Entity.Airport;
@Repository
public interface AirportRepository extends MongoRepository<Airport,String> {
    
}
