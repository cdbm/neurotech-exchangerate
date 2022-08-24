package com.neurotech.exchange.fixercurrencyapi;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.neurotech.exchange.models.ExchangeRate;
import com.neurotech.exchange.repository.ExchangeRateRepository;

@Component
public class FixerCurrencyClient {
	
	@Autowired
	ExchangeRateRepository repository;

	FixerCurrencyClient(){
		
	}
	
	@Scheduled(fixedRate = 60* 1000)
	public void fetchCurrentRate() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://v6.exchangerate-api.com/v6/6fac894f903fa57e9c338834/latest/BRL"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		String body = response.body();

		String USDvalue = getUsdValue(body);
		System.out.println(USDvalue);
		ExchangeRate rate = new ExchangeRate(USDvalue, new Date());
		
		this.repository.save(rate);
	}

	private String getUsdValue(String body) {
		int x = body.indexOf("USD");
		String substring = body.substring(x+5, x+20);
		
		String USDvalue = substring.split(",")[0];
		return USDvalue;
	}
	
}
