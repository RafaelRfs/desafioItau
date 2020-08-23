package com.br.rfs.desafio.itau.handler;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.br.rfs.desafio.itau.domain.TransactionRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.exception.AppException;
import com.br.rfs.desafio.itau.interfaces.Operations;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostTransaction implements Operations {
	
	/*
	 * 
	 * Classe de criação de Transações e validações de regras de negocios 
	 * orientada a objetos
	 * 
	 */

	@Override
	public void run(DesafioResponse response, Object data, Object service, List<TransactionRequest> desafioRequestList) 
			throws AppException {
		
		if(data instanceof TransactionRequest) {
			
			TransactionRequest request = (TransactionRequest) data;
			LocalDateTime now = LocalDateTime.now();
			
			if(request.getDataHora().isAfter(now)) {
				throw new AppException("Data da transação não permitida");
			}
			
			if(request.getValor().intValue() <= 0) {
				throw new AppException("Digite um valor de transação valido que seja maior que Zero");
			}
			
			desafioRequestList.add(request);
			response.setStatusCode(HttpStatus.CREATED);
			log.info("Transação criada com sucesso!");
		}
		
	}
	
}
