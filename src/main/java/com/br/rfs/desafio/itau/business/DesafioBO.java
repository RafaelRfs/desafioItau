package com.br.rfs.desafio.itau.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.br.rfs.desafio.itau.domain.DesafioRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.interfaces.Operations;
import com.br.rfs.desafio.itau.service.DesafioService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DesafioBO {
	@Autowired 
	private DesafioService service;
	
	public void process(Operations operations, DesafioRequest request, DesafioResponse<Object> response,
			List<DesafioRequest> desafioRequestList) {
		try {
			
			if(desafioRequestList == null) {
				desafioRequestList = new ArrayList<>();
			}
			
			operations.run(response, request, service);
			
			
			desafioRequestList.add(request);
			
			log.info("Transação criada com sucesso!");
			response.setStatusCode(HttpStatus.CREATED);
			
		} catch(Exception e) {
			log.error("Erro ao processar os dados >> ", e.getMessage(), e );
			response.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
			response.setMessage("Error:"+e.getMessage());
		}
	}
	
	

}
