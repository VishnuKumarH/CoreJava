package com.ust.spring.backend_airbook.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Document(collection = "airports")

@Data
@JsonIgnoreProperties(ignoreUnknown= true)
public class Airport {


	private String time_zone;

	private String name;

	private Double longitude;

	private Double latitude;

	private String id;

	private String icao_code;

	private String iata_country_code;

	private String iata_code;

	private String iata_city_code;

	private String city_name;

	private String city_iata_code;
    
}
