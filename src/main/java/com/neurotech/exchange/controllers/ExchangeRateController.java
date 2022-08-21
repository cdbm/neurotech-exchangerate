package com.neurotech.exchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neurotech.exchange.services.ExchangeRateService;

@RestController
public class ExchangeRateController {
	@Autowired
	private ExchangeRateService service;


	@GetMapping("/getRate")
	public void getRate() {
		try {
			this.service.getCurrentExchangeRate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
