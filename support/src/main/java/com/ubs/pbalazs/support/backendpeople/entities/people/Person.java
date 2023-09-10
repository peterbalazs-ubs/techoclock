package com.ubs.pbalazs.support.backendpeople.entities.people;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "people")
public class Person {

	@Id
	@GeneratedValue
	private UUID uuid;

	private String firstName;

	private String lastName;

	private String title;

	private String fullName;

	private Date dateOfBirth;

	@OneToMany(mappedBy = "person")
	private List<PersonAddress> addressList;

	@OneToMany(mappedBy = "person")
	private List<PhoneNumber> phoneNumberList;

	@OneToMany(mappedBy = "person")
	private List<EmailAddress> emailAddressList;
}
