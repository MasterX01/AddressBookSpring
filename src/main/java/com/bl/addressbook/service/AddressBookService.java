package com.bl.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bl.addressbook.dto.AddressResponseDTO;
import com.bl.addressbook.dto.PersonDTO;
import com.bl.addressbook.exception.AddressBookException;
import com.bl.addressbook.exception.AddressBookException.exceptionType;
import com.bl.addressbook.model.Person;
import com.bl.addressbook.repository.IAddressBookRepo;

@Service
public class AddressBookService implements IAddressBookService{

	@Autowired
	IAddressBookRepo addressBookRepo;
	
	@Override
	public AddressResponseDTO addPerson(PersonDTO person) {
		Person contact = new Person(person);
		return new AddressResponseDTO("Contact Added Successfully", addressBookRepo.save(contact));
	}

	@Override
	public ResponseEntity<AddressResponseDTO> listPerson() {
		List<Person> list =  addressBookRepo.findAll();
		return new ResponseEntity<>(new AddressResponseDTO("Here are all the contacts in the DB", list), HttpStatus.OK);
	}

	@Override
	public Person findPerson(int id) {
		return addressBookRepo.findById(id).orElseThrow(()-> new AddressBookException(exceptionType.CONTACT_NOT_FOUND, "Contact not found for the given ID"));
	}

	@Override
	public void deletePerson(int id) {
		addressBookRepo.deleteById(id);
	}

	@Override
	public AddressResponseDTO updatePerson(int id, PersonDTO person) {
		Person contact = new Person(id, person);
		return new AddressResponseDTO("Here are the Updated Details for the given ID", addressBookRepo.save(contact));
	}
	
}
