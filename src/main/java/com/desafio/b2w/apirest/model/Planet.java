package com.desafio.b2w.apirest.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Planets")
public class Planet {
	
	@Id
	private ObjectId id;
	
	private String name;
	private String climate;
	private String terrain;
	private int numberAppearences;
	

	public String getId() { 
		return id.toHexString(); 
	}
	public void setId(ObjectId id) { 
		this.id = id; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public int getNumberAppearences() {
		return numberAppearences;
	}
	public void setNumberAppearences(int numberAppearences) {
		this.numberAppearences = numberAppearences;
	}
}
