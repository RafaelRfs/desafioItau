package com.br.rfs.desafio.itau.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.br.rfs.desafio.itau.domain.TransactionRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.interfaces.Operations;
import com.br.rfs.desafio.itau.service.DesafioService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DesafioBO {
	
	@Autowired 
	private DesafioService service;
	
	
	/*
	 * 
	 * Classe Orquestradora das regras de negocio e Handlers
	 * Advindos do Controller
	 * 
	 * 
	 */
	
	public List<TransactionRequest> process(Operations operations, Object data, DesafioResponse<Object> response,
			List<TransactionRequest> desafioRequestList) {
		try {
			
			desafioRequestList = validateDesafioRequestList(desafioRequestList);
			
			operations.run(response, data, service,desafioRequestList);
			
		} catch(Exception e) {
			log.error("Erro ao processar os dados >> ", e.getMessage(), e );
			response.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
			response.setMessage("Error:"+e.getMessage());
		}
		
		return desafioRequestList;
	}

	/*
	 * Valida se ha alguma referencia na memoria para a lista de transações
	 * caso não haja, cria uma nova instancia para o objeto ser Single Instance
	 * 
	 */
	private List<TransactionRequest> validateDesafioRequestList(List<TransactionRequest> desafioRequestList) {
		if(desafioRequestList == null) {
			desafioRequestList = new ArrayList<>();
		}
		return desafioRequestList;
	}
	
}
