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
import com.br.rfs.desafio.itau.domain.DesafioRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.handler.PostTransaction;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(RequestEntrypointConstants.PATH_URL)
@Slf4j
public class DesafioController {
	
	@Autowired
	private DesafioBO desafioBO;
	
	private List<DesafioRequest> desafioRequest = new ArrayList<>();
	
	@PostMapping(RequestEntrypointConstants.TRANSACTION_URL)
	public ResponseEntity<Object> postTransaction(@Valid @RequestBody DesafioRequest request){
		DesafioResponse<Object> response = new DesafioResponse<>();
		PostTransaction post = new PostTransaction();
		desafioBO.process(post, request, response, desafioRequest);
		return new ResponseEntity<Object>(desafioRequest, response.getStatusCode());
	}
	
	@GetMapping(RequestEntrypointConstants.STATISTICS_URL)
	public ResponseEntity<Object> getStatistics(){
		DesafioResponse<Object> response = new DesafioResponse<>();
		return new ResponseEntity<Object>(response.getData(), response.getStatusCode());
	}
	
	@DeleteMapping(RequestEntrypointConstants.TRANSACTION_URL)
	public ResponseEntity<Object> deleteTransaction(){
		log.info("Transação excluida com sucesso!");
		desafioRequest = new ArrayList<>();
		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}

}
