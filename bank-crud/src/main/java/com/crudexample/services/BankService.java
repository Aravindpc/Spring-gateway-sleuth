package com.crudexample.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.sleuth.Span;
//import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

import com.crudexample.dto.BankSimpledto;
import com.crudexample.dto.Bankdto;
import com.crudexample.entity.Banks;
import com.crudexample.repository.BankRepository;

import brave.Tracer;
import zipkin2.Span;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;
	
	public static final Logger Logger=LoggerFactory.getLogger(BankService.class);

	public String createBank(Bankdto bankdto) {
    	String output;
    	Banks bank=new Banks();
    	BeanUtils.copyProperties(bankdto, bank);
		if( bankRepository.saveAndFlush(bank)!=null)
		{
			output="saved";
		}
		else
		{
			output="not_saved";
		}
		return output;
	}

    public String deleteBank(Long bank_id) {
    		bankRepository.deleteById(bank_id);
    		return "deleted";
	}
    public String updateBank(Bankdto bankdto, Long bank_id)
    {
    	String output;
    	Banks bank=bankRepository.getOne(bank_id);
    	BeanUtils.copyProperties(bankdto, bank);
		if(bankRepository.save(bank)!=null)
		{
			output="updated";
		}
		else
		{
			output="not_updated";
		}
		return output;
    }

    public List<Bankdto> getAllBank()
    {
    	
    	List<Banks> banks=bankRepository.findAll();
    	List<Bankdto> banksdto=new ArrayList<Bankdto>();
    	for(Banks bank:banks)
    	{
    		Bankdto bankdto=new Bankdto();
    		BeanUtils.copyProperties(bank,bankdto);
            banksdto.add(bankdto);
    	}
    	return banksdto;
    }
    
    public BankSimpledto getBank(Long bank_id)
    {
    	Logger.info("logs before custom span");
    	Banks bank=bankRepository.findById(bank_id).get();
    	Logger.info("After custom span");
    	BankSimpledto bankSimpledto=new BankSimpledto();
    	BeanUtils.copyProperties(bank,bankSimpledto);
    	return bankSimpledto;
    }

}
