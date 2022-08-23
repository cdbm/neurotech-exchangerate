package com.neurotech.exchange.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExchangeRate {
	private @Id @GeneratedValue Long id;
    private String valueInUSD;
    private Date fetchedAt;
    
    public ExchangeRate() {}
    
    public ExchangeRate(String valueInUSD, Date fecthedAt) {
    	this.valueInUSD = valueInUSD;
    	this.fetchedAt = fecthedAt;
    }
}
