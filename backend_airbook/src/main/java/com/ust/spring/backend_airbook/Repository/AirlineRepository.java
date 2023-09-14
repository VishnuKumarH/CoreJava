package com.ust.spring.backend_airbook.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.spring.backend_airbook.Entity.Airline;


@Repository
public interface AirlineRepository extends MongoRepository<Airline,String> {
    
}
