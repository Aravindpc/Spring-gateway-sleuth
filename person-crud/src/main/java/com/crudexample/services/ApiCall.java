package com.crudexample.services;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crudexample.dto.Bankdto;

@Service
public class ApiCall {

	public static final Logger Logger=LoggerFactory.getLogger(ApiCall.class);
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String bankServiceURL="http://localhost:8080";
	
	public Bankdto getBank(Long bank_id)
	{
		Logger.info("calling Bank service");
		Bankdto bankdto=restTemplate.getForObject(bankServiceURL+"/banks/getOneBank?bankid={bank_id}",Bankdto.class,bank_id);
		return bankdto;
	}
}
