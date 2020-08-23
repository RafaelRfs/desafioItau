package com.br.rfs.desafio.itau.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.rfs.desafio.itau.business.DesafioBO;
import com.br.rfs.desafio.itau.constants.RequestEntrypointConstants;
import com.br.rfs.desafio.itau.domain.TransactionRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.handler.DeleteTransaction;
import com.br.rfs.desafio.itau.handler.PostTransaction;
import com.br.rfs.desafio.itau.handler.StatisticsTransaction;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(RequestEntrypointConstants.PATH_URL)
public class DesafioController {
	
	@Autowired
	private DesafioBO desafioBO;
	
	private List<TransactionRequest> desafioRequestList;
	
	@PostMapping(RequestEntrypointConstants.TRANSACTION_URL)
	public ResponseEntity<Object> postTransaction(@Valid @RequestBody TransactionRequest request){
		DesafioResponse<Object> response = new DesafioResponse<>();
		desafioRequestList = desafioBO.process(new PostTransaction(), request, response, desafioRequestList);
		return new ResponseEntity<Object>(response.getData(), response.getStatusCode());
	}
	
	@GetMapping(RequestEntrypointConstants.STATISTICS_URL)
	public ResponseEntity<Object> getStatistics(){
		DesafioResponse<Object> response = new DesafioResponse<>();
		desafioBO.process(new StatisticsTransaction(), null, response, desafioRequestList);
		return new ResponseEntity<Object>(response.getData(), response.getStatusCode());
	}
	
	@DeleteMapping(RequestEntrypointConstants.TRANSACTION_URL)
	public ResponseEntity<Object> deleteTransaction(){
		DesafioResponse<Object> response = new DesafioResponse<>();
		desafioRequestList = desafioBO.process(new DeleteTransaction(), null, response, desafioRequestList);
		return new ResponseEntity<>(response.getData(),response.getStatusCode());
	}

}
