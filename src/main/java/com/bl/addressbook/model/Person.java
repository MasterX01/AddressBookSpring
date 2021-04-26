package com.bl.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bl.addressbook.dto.PersonDTO;

@Entity
@Table(name = "address_book")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipInt;
	private long pNoInt;
	private String email;
	private String type;
	
	public Person() {}
	
	public Person(PersonDTO person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.address = person.getAddress();
		this.city = person.getCity();
		this.state = person.getState();
		this.zipInt = person.getZipInt();
		this.pNoInt = person.getpNoInt();
		this.email = person.getEmail();
		this.type = person.getType();
	}

	public Person(int id, PersonDTO person) {
		this.id = id;
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.address = person.getAddress();
		this.city = person.getCity();
		this.state = person.getState();
		this.zipInt = person.getZipInt();
		this.pNoInt = person.getpNoInt();
		this.email = person.getEmail();
		this.type = person.getType();
	}
	
	public int getId() {return id;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getAddress() {return address;}
	public String getCity() {return city;}
	public String getState() {return state;}
	public int getZipInt() {return zipInt;}
	public long getpNoInt() {return pNoInt;}
	public String getEmail() {return email;}
	public String getType() {return type;}
}
