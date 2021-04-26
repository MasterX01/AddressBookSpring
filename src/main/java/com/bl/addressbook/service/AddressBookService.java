package com.bl.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bl.addressbook.dto.PersonDTO;
import com.bl.addressbook.model.Person;
import com.bl.addressbook.repository.IAddressBookRepo;

@Service
public class AddressBookService implements IAddressBookService{

	@Autowired
	IAddressBookRepo addressBookRepo;
	
	@Override
	public Person addPerson(PersonDTO person) {
		Person contact = new Person(person);
		return addressBookRepo.save(contact);
	}

	@Override
	public ResponseEntity<List<Person>> listPerson() {
		List<Person> list =  addressBookRepo.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public Person findPerson(int id) {
		return addressBookRepo.findById(id).get();
	}

	@Override
	public void deletePerson(int id) {
		addressBookRepo.deleteById(id);
	}

	@Override
	public Person updatePerson(int id, PersonDTO person) {
		Person contact = new Person(id, person);
		return addressBookRepo.save(contact);
	}
	
}
