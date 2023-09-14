package com.ust.spring.backend_airbook.Service;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

 

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.spring.backend_airbook.Entity.Airport;
import com.ust.spring.backend_airbook.Repository.AirportRepository;


 

@Service
public class AirportService {
    


    @Autowired
	private AirportRepository airportRepository;


	private final ResourceLoader resourceLoader;

 

    @Autowired
    public AirportService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    public void readJsonFileAndSaveToMongo(String filePath) throws IOException {
        // Load the JSON file as a Resource
//        Resource resource = resourceLoader.getResource(filePath);
        Resource resource = resourceLoader.getResource("classpath:AirportsData/airports-iata.json");

 

        // Read the JSON content from the Resource
        String jsonContent = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

 

        // Parse the JSON content into a list of YourModel objects
        ObjectMapper objectMapper = new ObjectMapper();
        List<Airport> airlineModel = objectMapper.readValue(jsonContent, objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));

 

        System.out.println(airlineModel);
        // Save the parsed data to MongoDB
        airportRepository.saveAll(airlineModel);


}
}
