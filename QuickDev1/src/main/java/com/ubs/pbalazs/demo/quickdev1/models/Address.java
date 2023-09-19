package com.ubs.pbalazs.demo.quickdev1.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {

	private String postalCode;

	private String town;

	private String street;

	private String streetNumber;

}
