package com.neurotech.exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.neurotech.exchange.models.ExchangeRate;
import com.neurotech.exchange.repository.ExchangeRateRepository;
import com.neurotech.exchange.services.ExchangeRateService;

@SpringBootTest
public class ExchangeRateServiceTests {

	@Autowired
	private ExchangeRateService service;
	
	@MockBean
	private ExchangeRateRepository repository;
	
	@Test
	public void getCurrentExchangeRateTest() throws IOException, InterruptedException {
		ExchangeRate rate = new ExchangeRate("0.15", new Date());
		
		when(this.repository.findFirstByOrderByIdDesc()).thenReturn(rate);
		
		ExchangeRate response = this.service.getCurrentExchangeRate();
		
		assertEquals(rate.getValueInUSD(), response.getValueInUSD());
		assertEquals(rate.getFetchedAt(), response.getFetchedAt());
	}
	
	@Test 
	public void findAllByFecthedAtBetweenTests() {
		ExchangeRate rate1 = new ExchangeRate("0.15", new Date());
		ExchangeRate rate2 = new ExchangeRate("0.16", new Date());
		
		List<ExchangeRate> rates = new ArrayList<>();
		rates.add(rate1);
		rates.add(rate2);
		
		Date d = new Date();
		
		when(this.repository.findAllByFetchedAtBetween(rate1.getFetchedAt(), d)).thenReturn(rates);
		
		List<ExchangeRate> response = this.service.findAllByFecthedAtBetween(rate1.getFetchedAt(), d);
		
		assertEquals(response.size(), rates.size());
		assertEquals(response.get(0).getValueInUSD(), rates.get(0).getValueInUSD());
		assertEquals(response.get(1).getValueInUSD(), rates.get(1).getValueInUSD());
		
	}
}
