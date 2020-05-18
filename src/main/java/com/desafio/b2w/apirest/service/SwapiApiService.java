package com.desafio.b2w.apirest.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.desafio.b2w.apirest.model.SwapiPlanet;
import com.desafio.b2w.apirest.model.SwapiResult;

@Service
public class SwapiApiService {
	
	public Integer getNumberAppearences(String movieName) {
		StringBuilder completeUrl = new StringBuilder();
		completeUrl.append("https://swapi.dev/api/planets/?search=").append(movieName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		SwapiResult swapiResult = restTemplate.getForObject(completeUrl.toString(), SwapiResult.class);
		
		if(swapiResult.getCount() == 0 || swapiResult == null) {
			return 0;
		}
		
		SwapiPlanet tempPlanet = Arrays.stream(swapiResult.getResults()).findFirst().get();
		
		return tempPlanet.getNumberAppearances();
	}
}
