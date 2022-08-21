package com.neurotech.exchange.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurotech.exchange.fixercurrencyapi.FixerCurrencyClient;

@Service
public class ExchangeRateService {
	@Autowired
	private FixerCurrencyClient client;
	
	public void getCurrentExchangeRate() throws IOException, InterruptedException {
		this.client.getCurrentRate();
	}
}
