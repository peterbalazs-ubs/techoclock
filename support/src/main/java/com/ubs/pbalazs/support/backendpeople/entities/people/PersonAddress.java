package com.ubs.pbalazs.support.backendpeople.entities.people;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "addresses")
public class PersonAddress {

	@Id
	@GeneratedValue
	private UUID uuid;

	@JsonIgnore
	@ToString.Exclude
	@ManyToOne
	private Person person;

	private String postalCode;

	private String town;

	private String street;

	private String streetNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String additionalAddressLine;

}
