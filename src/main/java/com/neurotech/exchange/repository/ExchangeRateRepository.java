package com.neurotech.exchange.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neurotech.exchange.models.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long>{

	public ExchangeRate findFirstByOrderByIdDesc();
	
	public List<ExchangeRate> findAllByFetchedAtBetween(
		      Date fetchedAtStart,
		      Date fetchedAtEnd);
}
