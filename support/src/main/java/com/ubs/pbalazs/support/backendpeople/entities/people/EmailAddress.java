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
@Table(name = "emails")
public class EmailAddress {

	@Id
	@GeneratedValue
	private UUID uuid;

	@JsonIgnore
	@ToString.Exclude
	@ManyToOne
	private Person person;

	private String emailAddress;

	private boolean secureCommunication;

}
