package com.ubs.pbalazs.demo.quickdev1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealEstate {

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
