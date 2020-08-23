package com.br.rfs.desafio.itau.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StatisticsDomain {
	
	private Integer count;
	private BigDecimal sum;
	private BigDecimal avg;
	private BigDecimal min;
	private BigDecimal max;

}
