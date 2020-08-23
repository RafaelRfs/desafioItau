package com.br.rfs.desafio.itau.interfaces;

import java.util.List;

import com.br.rfs.desafio.itau.domain.TransactionRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.exception.AppException;

public interface Operations {
	void run(DesafioResponse response, Object data, Object service, List<TransactionRequest> desafioRequestList) throws AppException;
}
