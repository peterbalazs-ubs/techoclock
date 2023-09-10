package com.ubs.pbalazs.support.backendpeople.entities.people;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "phonenumbers")
public class PhoneNumber {

	@Id
	@GeneratedValue
	private UUID uuid;

	@JsonIgnore
	@ToString.Exclude
	@ManyToOne
	private Person person;

	private String countryCode;

	private String localNumber;

	private String internationalFormat;

	private boolean smsCapable;

	private boolean whatsAppEnabled;

}
