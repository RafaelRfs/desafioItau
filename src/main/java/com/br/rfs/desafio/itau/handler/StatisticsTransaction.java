package com.br.rfs.desafio.itau.handler;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.HttpStatus;
import com.br.rfs.desafio.itau.domain.TransactionRequest;
import com.br.rfs.desafio.itau.domain.DesafioResponse;
import com.br.rfs.desafio.itau.domain.StatisticsDomain;
import com.br.rfs.desafio.itau.exception.AppException;
import com.br.rfs.desafio.itau.interfaces.Operations;

public class StatisticsTransaction implements Operations{
	
	private Stream<BigDecimal> getStreamBigDecimal(List<BigDecimal> values) {
		return values.stream();
	}

	@Override
	public void run(DesafioResponse serviceResponse, Object service, Object data, List<TransactionRequest> desafioRequestList) 
			throws AppException {
		
		StatisticsDomain stats = new StatisticsDomain();
		
		LocalDateTime tmMinus60Seconds = LocalDateTime.now();
		
		tmMinus60Seconds.minusSeconds(60L);
		
		List<TransactionRequest> transactions = desafioRequestList
				.parallelStream()
				.filter(t -> tmMinus60Seconds.isAfter(t.getDataHora()))
				.collect(Collectors.toList());
		
		stats.setCount(transactions.size());
		
		if(stats.getCount() > 0) {
		List<BigDecimal> values = transactions
				.stream()
				.map(t -> t.getValor())
				.collect(Collectors.toList());		
		
		BigDecimal sum = getStreamBigDecimal(values).reduce(BigDecimal.ZERO, BigDecimal::add);
		stats.setSum(sum);
				
		BigDecimal avg = stats.getCount() > 0 ? sum.divide(new BigDecimal(stats.getCount()), BigDecimal.ROUND_UP) : values.get(0);
		stats.setAvg(avg);	
		
		Optional<BigDecimal> max = getStreamBigDecimal(values).max(Comparator.naturalOrder());
		if(max.isPresent()) {
			stats.setMax(max.get());
		}
		
		Optional<BigDecimal> min = getStreamBigDecimal(values).min(Comparator.naturalOrder());
		if(min.isPresent()) {
			stats.setMin(min.get());
		}
		
		}else {
			BigDecimal zero = new BigDecimal(0);
			stats.setAvg(zero);
			stats.setCount(0);
			stats.setMax(zero);
			stats.setMin(zero);
			stats.setSum(zero);
		}
		
		
		serviceResponse.setData(stats);
		serviceResponse.setStatusCode(HttpStatus.OK);
		
	}


}
