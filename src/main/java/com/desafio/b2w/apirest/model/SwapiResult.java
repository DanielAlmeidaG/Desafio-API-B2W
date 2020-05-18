package com.desafio.b2w.apirest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResult {

	private int count;
    private SwapiPlanet[] results;
    
    public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public SwapiPlanet[] getResults() {
		return results;
	}
	public void setResults(SwapiPlanet[] results) {
		this.results = results;
	}
}
