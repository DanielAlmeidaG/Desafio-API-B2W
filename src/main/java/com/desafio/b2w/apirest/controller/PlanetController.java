package com.desafio.b2w.apirest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.b2w.apirest.exception.PlanetNotFoundException;
import com.desafio.b2w.apirest.model.Planet;
import com.desafio.b2w.apirest.model.PlanetIn;
import com.desafio.b2w.apirest.repository.PlanetRepository;
import com.desafio.b2w.apirest.service.SwapiApiService;

@RestController() 
@RequestMapping("/planets")
public class PlanetController {
	
	@Autowired  
	PlanetRepository repository;
	
	SwapiApiService swapiService = new SwapiApiService();

	@GetMapping("/")
	public ResponseEntity<?> getAllPlanets(){ 
		ResponseEntity<List<Planet>> response = new ResponseEntity<List<Planet>>(repository.findAll(), HttpStatus.OK);
		
		return response;
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id", required = true)	 String id){ 
		Optional<Planet> tempPlanet = repository.findById(id);

		if(!tempPlanet.isPresent()) {
			throw new PlanetNotFoundException("Planet not found for id: " + id);
		}
		
		ResponseEntity<Planet> response = new ResponseEntity<Planet>(tempPlanet.get(), HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping("/searchPlanet{name}")
	public ResponseEntity<?> getPlanetByName(@RequestParam String name){
		Optional<Planet> tempPlanet = repository.findByName(name);
		
		if(!tempPlanet.isPresent()) {
			throw new PlanetNotFoundException("Planet not found for name: " + name);
		}

		ResponseEntity<Planet> response = new ResponseEntity<Planet>(tempPlanet.get(), HttpStatus.OK);
		
		return response;
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPlanet(@Valid @RequestBody PlanetIn planetIn){
		
		Optional<Planet> checkPlanet = repository.findByName(planetIn.getName());
		if(checkPlanet.isPresent()) {
			String message = "Planet already exists for name: " + planetIn.getName();
			ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatus.CONFLICT);
			
			return response;
		}
		
		Planet tempPlanet = new Planet();
		
		tempPlanet.setId(new ObjectId());
		tempPlanet.setName(planetIn.getName());
		tempPlanet.setClimate(planetIn.getClimate());
		tempPlanet.setTerrain(planetIn.getTerrain());
		tempPlanet.setNumberAppearences(swapiService.getNumberAppearences(planetIn.getName()));
		
		repository.save(tempPlanet);
		
		ResponseEntity<Planet> response = new ResponseEntity<Planet>(tempPlanet, HttpStatus.CREATED);
		return response;
		
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePlanet(@PathVariable(value="id", required = true) String id){ 
		Optional<Planet> tempPlanet = repository.findById(id);

		if(!tempPlanet.isPresent()) {
			throw new PlanetNotFoundException("Planet not found for id: " + id);
		}
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
