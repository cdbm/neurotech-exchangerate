package com.neurotech.exchange.fixercurrencyapi;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

@Component
public class FixerCurrencyClient {

	FixerCurrencyClient(){
		
	}
	
	
	public void getCurrentRate() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://fixer-fixer-currency-v1.p.rapidapi.com/latest?base=USD&symbols=GBP%2CJPY%2CEUR"))
				.header("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
				.header("X-RapidAPI-Host", "fixer-fixer-currency-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response);
	}
	
}
