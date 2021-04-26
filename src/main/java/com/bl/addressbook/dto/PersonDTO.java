package com.bl.addressbook.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PersonDTO {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipInt;
	private long pNoInt;
	private String email;
	private String type;
	
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getAddress() {return address;}
	public String getCity() {return city;}
	public String getEmail() {return email;}
	public long getpNoInt() {return pNoInt;}
	public int getZipInt() {return zipInt;}
	public String getState() {return state;}
	public String getType() {return type;}
	
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setAddress(String address) {this.address = address;}
	public void setCity(String city) {this.city = city;}
	public void setState(String state) {this.state = state;}
	public void setZipInt(int zipInt) {this.zipInt = zipInt;}
	public void setpNoInt(long pNoInt) {this.pNoInt = pNoInt;}
	public void setEmail(String email) {this.email = email;}
	public void setType(String type) {this.type = type;}

}
