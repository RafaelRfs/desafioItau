package com.br.rfs.desafio.itau.handler;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.br.rfs.desafio.itau.domain.DesafioRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.exception.AppException;
import com.br.rfs.desafio.itau.interfaces.Operations;

public class PostTransaction implements Operations {

	@Override
	public void run(DesafioResponse response, Object data, Object service) throws AppException {
		
		if(data instanceof DesafioRequest) {
			
			DesafioRequest request = (DesafioRequest) data;
			LocalDateTime now = LocalDateTime.now();
			
			if(request.getDataHora().isAfter(now)) {
				throw new AppException("Data da transação não permitida");
			}
			
			if(request.getValor().intValue() <= 0) {
				throw new AppException("Digite um valor de transação valido que seja maior que Zero");
			}
		}
		
	}
	
}
