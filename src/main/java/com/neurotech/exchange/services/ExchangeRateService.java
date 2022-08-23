package com.neurotech.exchange.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurotech.exchange.models.ExchangeRate;
import com.neurotech.exchange.repository.ExchangeRateRepository;

@Service
public class ExchangeRateService {
	@Autowired
	private ExchangeRateRepository repository;
	
	public ExchangeRate getCurrentExchangeRate() throws IOException, InterruptedException {
		return this.repository.findFirstByOrderByIdDesc();
	}
	
	public List<ExchangeRate> findAllByFecthedAtBetween(Date startDate,Date endDate){
		return this.repository.findAllByFetchedAtBetween(startDate, endDate);
	}
}
