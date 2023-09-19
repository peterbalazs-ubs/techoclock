package com.ubs.pbalazs.demo.quickdev1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

	private String countryCode;

	private String localNumber;

	private String internationalFormat;

	private boolean smsCapable;

	private boolean whatsAppEnabled;
}
