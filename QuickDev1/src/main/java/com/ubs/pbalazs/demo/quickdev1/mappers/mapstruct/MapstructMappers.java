package com.ubs.pbalazs.demo.quickdev1.mappers.mapstruct;

import com.ubs.pbalazs.demo.quickdev1.api.models.Requester;
import com.ubs.pbalazs.demo.quickdev1.models.EmailAddress;
import com.ubs.pbalazs.demo.quickdev1.models.Person;
import com.ubs.pbalazs.demo.quickdev1.models.PhoneNumber;
import com.ubs.pbalazs.demo.quickdev1.models.RealEstate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapstructMappers {

	@Mapping(source = "email", target = "emailAddressList", qualifiedByName = "emailToList")
	@Mapping(source = "phone", target = "phoneNumberList", qualifiedByName = "phoneNumberToList")
	@Mapping(target = "addressList", expression = "java(java.util.Collections.emptyList())")
	@Mapping(target = "fullName", expression = "java(org.apache.commons.text.CaseUtils.toCamelCase(requester.getTitle().name(), true) + \". \" + requester.getFirstName() + ' ' + requester.getLastName())")
	Person toPerson(Requester requester);

	@Mapping(source = "lotSize", target = "landSize")
	@Mapping(source = "address.postalCode", target = "postalCode")
	@Mapping(source = "address.town", target = "city")
	@Mapping(source = "address.street", target = "streetName")
	@Mapping(source = "address.number", target = "streetNumber")
	@Mapping(target = "numberOfBathRooms", constant = "0")
	@Mapping(target = "numberOfToilets", constant = "0")
	RealEstate toRealEstate(com.ubs.pbalazs.demo.quickdev1.api.models.RealEstate re);

	@Named("emailToList")
	default List<EmailAddress> emailToList(final String email) {
		return Collections.singletonList(EmailAddress.builder()
						.emailAddress(email)
						.secureCommunication(true)
				.build());
	}

	@Named("phoneNumberToList")
	default List<PhoneNumber> phoneNumberToList(final String phoneNumber) {
		return Collections.singletonList(PhoneNumber.builder()
						.localNumber(phoneNumber)
						.countryCode("+41")
						.internationalFormat("+41" + phoneNumber.substring(1))
						.smsCapable(false)
						.whatsAppEnabled(false)
				.build());
	}
}
