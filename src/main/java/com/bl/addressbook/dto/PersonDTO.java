package com.bl.addressbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class PersonDTO {
	
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}+[a-z]{2,}", message = "First Name is Invalid (Starts with Capital Letter, Should Not Contain Numbers, Length more than 3)")	
	private String firstName;

	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}+[a-z]{2,}", message = "Last Name is Invalid (Starts with Capital Letter, Should Not Contain Numbers, Length more than 3)")	
	private String lastName;
	
	@NotEmpty(message = "Address cannot be empty")
	private String address;
	
	@NotEmpty(message = "City Connot be empty")
	private String city;
	
	@NotEmpty(message = "State Connot be empty")
	private String state;
	
	@NotNull(message = "Zip Code cannot be empty")
	private int zip;

	@NotNull(message = "Phone Number cannot be empty")
	private long phone;
	
	@NotEmpty
	@Email
	private String email;
	
//	@NotEmpty(message = "Address Book type cannot be empty")
//	private String type;
	
	
}
