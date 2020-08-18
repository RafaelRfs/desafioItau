package com.br.rfs.desafio.itau.exception;

public class AppException extends Exception {
	
	public AppException(String msg){
        super(msg);
    }

    public AppException(String msg, Throwable throwable){
        super(msg, throwable);
    }

}
