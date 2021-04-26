package com.bl.addressbook.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bl.addressbook.dto.PersonDTO;
import com.bl.addressbook.model.Person;

public interface IAddressBookService {

	Person addPerson(PersonDTO person);

	ResponseEntity<List<Person>> listPerson();

	Person findPerson(int id);

	void deletePerson(int id);

	Person updatePerson(int id, PersonDTO person);

}
