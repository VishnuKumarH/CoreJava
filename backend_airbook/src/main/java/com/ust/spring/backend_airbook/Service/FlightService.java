package com.ust.spring.backend_airbook.Service;




import java.io.File;

import java.io.IOException;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.util.ResourceUtils;

 

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.spring.backend_airbook.Entity.Flight;
import com.ust.spring.backend_airbook.Repository.FlightRepository;


 

@Service

public class FlightService {


    @Autowired

	private FlightRepository flightRepository;

	

	

	public void importFlightsFromJsonFile() {

        try {

            // Load the JSON file from the classpath (assuming it's in the resources folder)

            File jsonFile = ResourceUtils.getFile("classpath:airline-data/flights_routes.json");

 

            // Initialize ObjectMapper to deserialize JSON

            ObjectMapper objectMapper = new ObjectMapper();

 

            // Read JSON data into a list of Flight objects

            List<Flight> flights = objectMapper.readValue(jsonFile, new TypeReference<List<Flight>>() {});

 

            // Save the list of Flight objects to MongoDB

            flightRepository.saveAll(flights);

 

            System.out.println("Imported " + flights.size() + " flights from JSON file to MongoDB.");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
    
}
