package com.bl.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.addressbook.dto.PersonDTO;
import com.bl.addressbook.model.Person;
import com.bl.addressbook.service.IAddressBookService;

@RestController
public class AddressBookController {

	@Autowired
	IAddressBookService addressBook;
	
	/**
	 * API to add new person to DB
	 * @param person
	 * @return Added Person
	 */
	@PostMapping("/addperson")
	public ResponseEntity<Person> addPerson(@RequestBody PersonDTO person) {
		Person addedPerson = addressBook.addPerson(person);
		return new ResponseEntity<>(addedPerson, HttpStatus.CREATED);
	}
	
	/**
	 * API to read all contacts in DB
	 * @return List of Person
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Person>> listPersons(){
		return addressBook.listPerson();
	}
	
	/**
	 * API to find contact by ID
	 * @param id
	 * @return Person
	 */
	@GetMapping("/find/{id}")
	public Person findPerson(@PathVariable int id) {
		return addressBook.findPerson(id);
	}
	
	/**
	 * API to delete contact from DB
	 * @param contact ID
	 */
	@DeleteMapping("/delete/{id}")
	public void deleteContact(@PathVariable int id) {
		addressBook.deletePerson(id);
	}
	
	/**
	 * API to update contact details
	 * @param contact id
	 * @param person
	 * @return person data
	 */
	@PutMapping("/update/{id}")
	public Person updateContact(@PathVariable int id, @RequestBody PersonDTO person) {
		return addressBook.updatePerson(id, person);
	}
}
