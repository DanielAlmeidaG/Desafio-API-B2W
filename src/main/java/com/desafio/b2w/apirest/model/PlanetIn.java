package com.desafio.b2w.apirest.model;

import javax.validation.constraints.NotBlank;

public class PlanetIn {

	@NotBlank(message = "name cannot be blank or null")
	private String name;

	@NotBlank(message = "climate cannot be blank or null")
	private String climate;

	@NotBlank(message = "terrain cannot be blank or null")
	private String terrain;

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
}
