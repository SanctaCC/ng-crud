package com.example.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entity.Person;
import com.example.repository.PersonCrudRepository;

@RestController
@RequestMapping("api")
public class IndexController {
	
	private final String ANGULAR_HOST = "http://localhost:4200";

	@Autowired
	private PersonCrudRepository personRepository;

	@GetMapping("/persons/{id}")
	@CrossOrigin(ANGULAR_HOST)
	public ResponseEntity<Person> getPerson(@PathVariable int id) {
		return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
	}
	
	@CrossOrigin(ANGULAR_HOST)
	@PostMapping(value = "/persons", consumes = "application/json")
	public ResponseEntity<?> addPerson(@RequestBody Person person) {
		personRepository.save(person);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newPollUri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}")
				.buildAndExpand(person.getId())
				.toUri();
		responseHeaders.setLocation(newPollUri);
		return new ResponseEntity<>(null,responseHeaders,HttpStatus.CREATED);
	}
	
	@CrossOrigin(ANGULAR_HOST)
	@GetMapping("/persons")
	public ResponseEntity<Iterable<Person>> getAll(){
		return new ResponseEntity<>(personRepository.findAll(),HttpStatus.OK);
	}

}
