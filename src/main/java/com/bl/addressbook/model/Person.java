package com.bl.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bl.addressbook.dto.PersonDTO;

import lombok.Data;

@Entity
@Table(name = "address_book")
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phone;
	private String email;
//	private String type;
	
	public Person() {}
	
	public Person(PersonDTO person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.address = person.getAddress();
		this.city = person.getCity();
		this.state = person.getState();
		this.zip = person.getZip();
		this.phone = person.getPhone();
		this.email = person.getEmail();
//		this.type = person.getType();
	}

	public Person(int id, PersonDTO person) {
		this.id = id;
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.address = person.getAddress();
		this.city = person.getCity();
		this.state = person.getState();
		this.zip = person.getZip();
		this.phone = person.getPhone();
		this.email = person.getEmail();
//		this.type = person.getType();
	}
	
	
}
