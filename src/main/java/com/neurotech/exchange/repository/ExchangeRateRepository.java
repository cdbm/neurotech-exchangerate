package com.neurotech.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neurotech.exchange.models.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long>{

	public ExchangeRate findFirstByOrderByIdDesc();
}
