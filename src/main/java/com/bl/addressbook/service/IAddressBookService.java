package com.bl.addressbook.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bl.addressbook.dto.AddressResponseDTO;
import com.bl.addressbook.dto.PersonDTO;
import com.bl.addressbook.model.Person;

public interface IAddressBookService {

	AddressResponseDTO addPerson(PersonDTO person);

	ResponseEntity<AddressResponseDTO> listPerson();

	Person findPerson(int id);

	void deletePerson(int id);

	AddressResponseDTO updatePerson(int id, PersonDTO person);

	List<Person> findByCityOrState(String search);

}
