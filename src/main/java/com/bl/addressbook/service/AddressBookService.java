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

/**
 * Service Layer to contact with the repository layer
 * Methods to implement API and make changes to Database
 * @author Akash Saxena
 */
@Service
public class AddressBookService implements IAddressBookService{

	/**
	 * Object to repository interface
	 */
	@Autowired
	IAddressBookRepo addressBookRepo;
	
	/**
	 * ADD new person to Database
	 * @param person DTO
	 * @return addressbook response DTO containing person details and a message
	 */
	@Override
	public AddressResponseDTO addPerson(PersonDTO person) {
		Person contact = new Person(person);
		return new AddressResponseDTO("Contact Added Successfully", addressBookRepo.save(contact));
	}

	/**
	 * List all the persons in the database
	 * @return response entity of addressbook response dto
	 */
	@Override
	public ResponseEntity<AddressResponseDTO> listPerson() {
		List<Person> list =  addressBookRepo.findAll();
		return new ResponseEntity<>(new AddressResponseDTO("Here are all the contacts in the DB", list), HttpStatus.OK);
	}

	/**
	 * Find a contact based on the given id
	 * @param id
	 * @return person data
	 */
	@Override
	public Person findPerson(int id) {
		return addressBookRepo.findById(id).orElseThrow(()-> new AddressBookException(exceptionType.CONTACT_NOT_FOUND, "Contact not found for the given ID"));
	}

	/**
	 * delete a person data from database
	 * @param contact id
	 */
	@Override
	public void deletePerson(int id) {
		addressBookRepo.deleteById(id);
	}

	/**
	 * Update a contact details 
	 * @param contact id and person DTO
	 * @return updated details of the person in addressbook response DTO
	 */
	@Override
	public AddressResponseDTO updatePerson(int id, PersonDTO person) {
		Person contact = new Person(id, person);
		return new AddressResponseDTO("Here are the Updated Details for the given ID", addressBookRepo.save(contact));
	}

	/**
	 * Find a contact who belongs to either a city or state given
	 * @param name of either a city or a state
	 * @return list of persons
	 */
	@Override
	public List<Person> findByCityOrState(String search) {
		return addressBookRepo.findByCityOrState(search);
	}
	
}
