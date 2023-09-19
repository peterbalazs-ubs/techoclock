package com.ubs.pbalazs.demo.quickdev1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailAddress {

	private String emailAddress;

	private boolean secureCommunication;
}
