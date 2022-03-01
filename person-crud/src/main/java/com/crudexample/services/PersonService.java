package com.crudexample.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudexample.dto.Bankdto;
import com.crudexample.dto.Persondto;
import com.crudexample.entity.Person;
import com.crudexample.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ApiCall apiCall;
	    
    public String createPerson(Persondto persondto) {
    	String output;
    	Person person=new Person();
    	BeanUtils.copyProperties(persondto,person);
    	System.out.println(person);
    	System.out.println(persondto);
		if( personRepository.saveAndFlush(person)!=null)
		{
			output="saved";
		}
		else
		{
			output="not_saved";
		}
		return output;
	}

    public String deletePerson(Long person_id) {
    		personRepository.deleteById(person_id);
    		return "deleted";
	}
    public String updatePerson(Persondto persondto, Long person_id)
    {
    	String output;
    	Person person=personRepository.getOne(person_id);
    	BeanUtils.copyProperties(persondto,person);
    	System.out.println(person);
    	System.out.println(persondto);
		if(personRepository.save(person)!=null)
		{
			output="updated";
		}
		else
		{
			output="not_updated";
		}
		return output;
    }

    public List<Persondto> getAllPerson()
    {
    	List<Person> persons=personRepository.findAll();
    	List<Persondto> personsdto=new ArrayList<Persondto>();
    	for(Person person:persons)
    	{
    		Persondto persondto=new Persondto();
            BeanUtils.copyProperties(person, persondto);
            System.out.println(person);
        	System.out.println(persondto);
        	personsdto.add(persondto);
    	}
    	return personsdto;
    }
    
    public Persondto getPerson(Long person_id)
    {
    	Person person=personRepository.findById(person_id).get();
    	Bankdto bank=apiCall.getBank(person.getBank_id());
    	Persondto persondto = new Persondto();
    	BeanUtils.copyProperties(person, persondto);
    	persondto.setBank(bank);
    	System.out.println(person);
    	System.out.println(persondto);
    	return persondto;    	 
    }

}
