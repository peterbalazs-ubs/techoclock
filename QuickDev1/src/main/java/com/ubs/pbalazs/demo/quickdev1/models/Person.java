package com.ubs.pbalazs.demo.quickdev1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private String firstName;

	private String lastName;

	private String title;

	private String fullName;

	private Date dateOfBirth;

	private List<Address> addressList;

	private List<PhoneNumber> phoneNumberList;

	private List<EmailAddress> emailAddressList;

}
