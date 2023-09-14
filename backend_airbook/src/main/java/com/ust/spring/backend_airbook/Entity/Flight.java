package com.ust.spring.backend_airbook.Entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;





@Document(collection = "flight-routes") // MongoDB collection name

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight {


       @Id

	private Integer id;

 

	@JsonProperty("iata_from")

	private String iataFrom;

 

	@JsonProperty("iata_to")

	private String iataTo;

 

	private String airLineIata;

 

	@JsonProperty("airline") // Use this annotation to specify the JSON field name

	private void unpackNestedIATA(Map<String, Object> airline) {

		this.airLineIata = (String) airline.get("IATA");

	}

 

	@JsonProperty("airportVia")

	private String airportVia;

 

	@JsonProperty("class_business")

	private boolean classBusiness;

 

	@JsonProperty("class_economy")

	private boolean classEconomy;

 

	@JsonProperty("class_first")

	private boolean classFirst;

 

	private String day1;

 

	private String day2;

 

	private String day3;

 

	private String day4;

 

	private String day5;

 

	private String day6;

 

	private String day7;

 

	@JsonProperty("max_duration")

	private int maxDuration;

 

	@JsonProperty("min_duration")

	private int minDuration;
    
}
