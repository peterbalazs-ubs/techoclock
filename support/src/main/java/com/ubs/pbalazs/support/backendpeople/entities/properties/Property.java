package com.ubs.pbalazs.support.backendpeople.entities.properties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue
	private UUID uuid;

	private String postalCode;

	private String city;

	private String streetName;

	private String streetNumber;

	private int landSize;

	private int livingSize;

	private BigDecimal numberOfRooms;

	private int numberOfBathRooms;

	private int numberOfToilets;

}
