package com.neurotech.exchange.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurotech.exchange.fixercurrencyapi.FixerCurrencyClient;
import com.neurotech.exchange.models.ExchangeRate;
import com.neurotech.exchange.repository.ExchangeRateRepository;

@Service
public class ExchangeRateService {
	@Autowired
	private ExchangeRateRepository repository;
	
	public ExchangeRate getCurrentExchangeRate() throws IOException, InterruptedException {
		return this.repository.findFirstByOrderByIdDesc();
	}
}
