package com.br.rfs.desafio.itau.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.rfs.desafio.itau.business.DesafioBO;
import com.br.rfs.desafio.itau.constants.RequestEntrypointConstants;
import com.br.rfs.desafio.itau.domain.DesafioRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.handler.PostTransaction;

@RestController
@RequestMapping(RequestEntrypointConstants.PATH_URL)
public class DesafioController {
	
	@Autowired
	private DesafioBO desafioBO;
	
	@GetMapping(RequestEntrypointConstants.TRANSACTION_URL)
	public ResponseEntity<Object> postTransaction(@Valid @RequestBody DesafioRequest request){
		DesafioResponse<Object> response = new DesafioResponse<>();
		PostTransaction post = new PostTransaction();
		desafioBO.process(post, request, response );
		return new ResponseEntity<Object>(response.getData(), response.getStatusCode());
	}
	
	@GetMapping(RequestEntrypointConstants.STATISTICS_URL)
	public ResponseEntity<Object> getStatistics(){
		DesafioResponse<Object> response = new DesafioResponse<>();
		return new ResponseEntity<Object>(response.getData(), response.getStatusCode());
	}
	
	@DeleteMapping(RequestEntrypointConstants.TRANSACTION_URL+"/{id}")
	public ResponseEntity<Object> deleteTransaction(@PathVariable int id){
		DesafioResponse<Object> response = new DesafioResponse<>();
		return new ResponseEntity<Object>(response.getData(), response.getStatusCode());
	}

}
