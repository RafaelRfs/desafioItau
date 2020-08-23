package com.br.rfs.desafio.itau.handler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.br.rfs.desafio.itau.domain.TransactionRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.exception.AppException;
import com.br.rfs.desafio.itau.interfaces.Operations;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeleteTransaction implements Operations{
	
	@Override
	public void run(DesafioResponse serviceResponse, Object service, Object data,  List<TransactionRequest> desafioRequestList) 
			throws AppException {
		desafioRequestList.clear();
		serviceResponse.setStatusCode(HttpStatus.NO_CONTENT);
		log.info("Transações excluídas com sucesso!");
	}

}
