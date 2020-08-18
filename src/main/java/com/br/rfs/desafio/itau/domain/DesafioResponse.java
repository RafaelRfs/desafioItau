package com.br.rfs.desafio.itau.domain;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DesafioResponse<T>{
	
	private HttpStatus statusCode;
	
	private T data;

}
