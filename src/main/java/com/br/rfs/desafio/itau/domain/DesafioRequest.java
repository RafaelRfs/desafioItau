package com.br.rfs.desafio.itau.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DesafioRequest implements Serializable {
	
	@NotNull
	private BigDecimal valor;
	@NotNull
	private Date dataHora;

}
