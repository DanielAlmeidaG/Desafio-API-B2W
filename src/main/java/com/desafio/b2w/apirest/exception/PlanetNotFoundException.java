package com.desafio.b2w.apirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanetNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -412646269835041518L;

	public PlanetNotFoundException(String message) {
		super(message);
	}

}
