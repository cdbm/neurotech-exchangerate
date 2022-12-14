package com.neurotech.exchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neurotech.exchange.dto.DBetweenDates;
import com.neurotech.exchange.services.ExchangeRateService;

@RestController
public class ExchangeRateController {
	@Autowired
	private ExchangeRateService service;


	@GetMapping("/getRate")
	public ResponseEntity getRate() {
		try {
			return ResponseEntity.ok(this.service.getCurrentExchangeRate());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		
	}
	
	@GetMapping("/findBetweenDates")
	public ResponseEntity findBetweenDates(@RequestBody DBetweenDates dates) {
		try {
			return ResponseEntity.ok(this.service.findAllByFecthedAtBetween(dates.getStartDate(), dates.getEndDate()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		
	}
}
