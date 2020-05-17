package com.desafio.b2w.apirest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController() 
@RequestMapping("/planets")
public class PlanetController {
	
	@Autowired  
	PlanetRepository repository;

	@GetMapping("/")
	public List<Planet> getAllPlanets(){ 
		return repository.findAll();
	} 
	
	@GetMapping("/{id}")
	public Optional<Planet> findById(@PathVariable(value="id", required = true)	 String id){ 
		Optional<Planet> tempPlanet = repository.findById(id);

		if(tempPlanet.toString().equals("Optional.empty")) {
			throw new PlanetNotFoundException("Planet not found with id: " + id);
		}
	
		return tempPlanet;
	}
	
	@GetMapping("/searchPlanet{name}")
	public Optional<Planet> getPlanetByName(@RequestParam String name){ 
		return repository.findByName(name);
	}
	
	@PostMapping("/")
	public String addPlanet(@Valid @RequestBody PlanetIn planetIn){
		
		Planet tempPlanet = new Planet();
		
		tempPlanet.setId(new ObjectId());
		tempPlanet.setName(planetIn.getName());
		tempPlanet.setClimate(planetIn.getClimate());
		tempPlanet.setTerrain(planetIn.getTerrain());
		tempPlanet.setNumberAppearences(0);
		
		repository.save(tempPlanet);
		
		return "Planet added with id: " + tempPlanet.getId();
		
	} 
	
	@DeleteMapping("/{id}")
	public void deletePlanet(@PathVariable(value="id", required = true)	 String id){ 
		repository.deleteById(id);
	}
}
