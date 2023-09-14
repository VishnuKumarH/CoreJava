package com.ust.spring.backend_airbook.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

 

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.spring.backend_airbook.Entity.Airline;
import com.ust.spring.backend_airbook.Repository.AirlineRepository;

import lombok.ToString;

 



@Service
@ToString
public class AirlineService {


    //	String filePath = "./src/main/resources/airline-data/airports-iata.json";

 

	@Autowired
	private AirlineRepository airlineRepository;


	private final ResourceLoader resourceLoader;

 

    @Autowired
    public AirlineService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

 

 

	public void readJsonFile(String filePath) throws IOException {


		ObjectMapper objectMapper = new ObjectMapper();
		File jsonFile = new File(filePath);

		Airline[] airline = objectMapper.readValue(jsonFile, Airline[].class);

		System.out.println(Arrays.asList(airline));

	}

	public void readJsonFileAndSaveToMongo(String filePath) throws IOException {
        // Load the JSON file as a Resource
//        Resource resource = resourceLoader.getResource(filePath);
        Resource resource = resourceLoader.getResource("classpath:AirlineData/airlines-data.json");

 

        // Read the JSON content from the Resource
        String jsonContent = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

 

        // Parse the JSON content into a list of YourModel objects
        ObjectMapper objectMapper = new ObjectMapper();
        List<Airline> airlineModel = objectMapper.readValue(jsonContent, objectMapper.getTypeFactory().constructCollectionType(List.class, Airline.class));

 

        System.out.println(airlineModel);
        // Save the parsed data to MongoDB
        airlineRepository.saveAll(airlineModel);

    
}

}