package com.ust.spring.backend_airbook.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



@Document(collection = "airlines")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {

    private String name;
	@Id
	private String code;
	private String iata_code;
    private boolean is_lowcost;
    private String logo;
    
}
