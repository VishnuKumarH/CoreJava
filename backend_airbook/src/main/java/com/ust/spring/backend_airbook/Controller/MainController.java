package com.ust.spring.backend_airbook.Controller;




import java.io.IOException;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.ust.spring.backend_airbook.Service.AirlineService;
import com.ust.spring.backend_airbook.Service.AirportService;
import com.ust.spring.backend_airbook.Service.FlightService;

 
 

@RestController

@RequestMapping("/api/v1/flights")

public class MainController {
    


    @Autowired

	private AirlineService airlineService;

	

	@Autowired

	private AirportService airportService;

	

	@Autowired

    private FlightService flightService;

 

    @PostMapping("/importFlights")

    public void importFlights() {

        flightService.importFlightsFromJsonFile();

    }

	

	

	@PostMapping("/readAirline")

    public void readAndSaveAirline(@RequestParam String filePath) throws IOException {

        airlineService.readJsonFileAndSaveToMongo(filePath);

    }

	

	@PostMapping("/readAirport")

    public ResponseEntity<String> readAndSaveAirport(@RequestParam String filePath) throws IOException {

        airportService.readJsonFileAndSaveToMongo(filePath);

        return new ResponseEntity<>("Data Added...", HttpStatus.OK);

    }

	

	
}
