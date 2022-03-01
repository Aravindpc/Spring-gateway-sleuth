package com.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudexample.dto.Persondto;
import com.crudexample.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/getPersons")
	public ResponseEntity<List<Persondto>> getPersons() {
		List<Persondto> output = personService.getAllPerson();
		System.out.println(personService.getAllPerson().get(0));
		return ResponseEntity.ok(output);
	}
	@GetMapping("/getOnePerson")
	public ResponseEntity<Persondto> getOnePerson(@RequestParam(value = "personid") Long person_id) {
		Persondto output = personService.getPerson(person_id);
		return ResponseEntity.ok(output);
	}
	
	@PostMapping(value = "/createPerson")
	public ResponseEntity<String> register(@RequestBody Persondto persons) {
		String output =personService.createPerson(persons);
		
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updatePerson/{id}")
	public ResponseEntity<String> update(@PathVariable(value="id")Long person_id,@RequestBody Persondto persons) {
		String output =personService.updatePerson(persons,person_id);
		
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	@DeleteMapping(value = "/deleteperson")
	public ResponseEntity<String> delete(@RequestParam(value = "personid") Long person_id) {
		String output =personService.deletePerson(person_id);
		
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
}
