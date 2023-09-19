package com.ubs.pbalazs.demo.quickdev1.mappers.modelmapper;

import com.ubs.pbalazs.demo.quickdev1.api.models.RealEstate;
import com.ubs.pbalazs.demo.quickdev1.api.models.Requester;
import com.ubs.pbalazs.demo.quickdev1.models.EmailAddress;
import com.ubs.pbalazs.demo.quickdev1.models.Person;
import com.ubs.pbalazs.demo.quickdev1.models.PhoneNumber;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		final var modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setAmbiguityIgnored(true)
				.setFieldMatchingEnabled(true);

		final var personTypeMap = modelMapper.createTypeMap(Requester.class, Person.class);
		personTypeMap.addMappings(mapper -> mapper.map(
				Requester::getEmail,
				(destination, value) -> destination.setEmailAddressList(Collections.singletonList(EmailAddress.builder()
						.emailAddress((String) value)
						.secureCommunication(false)
						.build()))))
				.addMappings(mapper -> mapper.map(
						Requester::getPhone,
						(destination, value) -> destination.setPhoneNumberList(Collections.singletonList(PhoneNumber.builder()
								.localNumber((String) value)
								.countryCode("+41")
								.internationalFormat("+41" + (value + "").substring(1))
								.smsCapable(true)
								.whatsAppEnabled(false)
								.build()))));

		final var realEstateTypeMap = modelMapper.createTypeMap(RealEstate.class, com.ubs.pbalazs.demo.quickdev1.models.RealEstate.class);
		realEstateTypeMap
				.addMapping(RealEstate::getLotSize, com.ubs.pbalazs.demo.quickdev1.models.RealEstate::setLandSize)
				.addMappings(mapper -> mapper.map(
						src -> src.getAddress().getPostalCode(), com.ubs.pbalazs.demo.quickdev1.models.RealEstate::setPostalCode
				))
				.addMappings(mapper -> mapper.map(
						src -> src.getAddress().getTown(), com.ubs.pbalazs.demo.quickdev1.models.RealEstate::setCity
				))
				.addMappings(mapper -> mapper.map(
						src -> src.getAddress().getStreet(), com.ubs.pbalazs.demo.quickdev1.models.RealEstate::setStreetName
				))
				.addMappings(mapper -> mapper.map(
						src -> src.getAddress().getNumber(), com.ubs.pbalazs.demo.quickdev1.models.RealEstate::setStreetNumber
				));


		return modelMapper;
	}

}
