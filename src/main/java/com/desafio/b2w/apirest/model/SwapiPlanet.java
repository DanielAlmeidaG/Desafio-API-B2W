package com.desafio.b2w.apirest.model;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiPlanet {

    private URI[] films;
    
    public int getNumberAppearances() {
        return this.getFilms() == null ? 0 : this.getFilms().length;
    }

	public URI[] getFilms() {
		return films;
	}

	public void setFilms(URI[] films) {
		this.films = films;
	}
}
