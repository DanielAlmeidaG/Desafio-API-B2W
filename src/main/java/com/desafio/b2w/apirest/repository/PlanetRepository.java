package com.desafio.b2w.apirest.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.desafio.b2w.apirest.model.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String>{
	
	Optional<Planet> findByName(String name);

}
