package com.ubs.pbalazs.demo.quickdev1.mappers.orika;

import com.ubs.pbalazs.demo.quickdev1.api.models.RealEstate;
import com.ubs.pbalazs.demo.quickdev1.api.models.Requester;
import com.ubs.pbalazs.demo.quickdev1.models.EmailAddress;
import com.ubs.pbalazs.demo.quickdev1.models.Person;
import com.ubs.pbalazs.demo.quickdev1.models.PhoneNumber;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.Type;
import org.apache.commons.text.CaseUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;

@Component
public class OrikaMapperConfig extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.getConverterFactory().registerConverter(new BigDecimalToIntegerConverter());

		factory.classMap(Requester.class, Person.class)
				.byDefault()
				.customize(new CustomMapper<>() {
					@Override
					public void mapAtoB(Requester requester, Person person, MappingContext context) {
						person.setEmailAddressList(Collections.singletonList(EmailAddress.builder()
										.emailAddress(requester.getEmail())
										.secureCommunication(true)
								.build()));
						person.setPhoneNumberList(Collections.singletonList(PhoneNumber.builder()
										.localNumber(requester.getPhone())
										.countryCode("+41")
										.internationalFormat("+41"  + requester.getPhone().substring(1))
										.smsCapable(false)
										.whatsAppEnabled(false)
								.build()));
						person.setAddressList(Collections.emptyList());
						person.setFullName(CaseUtils.toCamelCase(person.getTitle(), true) + ". " + person.getFirstName() + ' ' + person.getLastName());
					}
				})
				.register();

		factory.classMap(RealEstate.class, com.ubs.pbalazs.demo.quickdev1.models.RealEstate.class)
				.byDefault()
				.field("lotSize", "landSize")
				.field("address.postalCode", "postalCode")
				.field("address.town", "city")
				.field("address.street", "streetName")
				.field("address.number", "streetNumber")
				.customize(new CustomMapper<>() {
					@Override
					public void mapAtoB(RealEstate realEstate, com.ubs.pbalazs.demo.quickdev1.models.RealEstate realEstate2, MappingContext context) {
						realEstate2.setNumberOfBathRooms(0);
						realEstate2.setNumberOfToilets(0);
					}
				})
				.register();
	}

	static class BigDecimalToIntegerConverter extends CustomConverter<BigDecimal, Integer> {

		@Override
		public Integer convert(BigDecimal source, Type<? extends Integer> destinationType, MappingContext mappingContext) {
			return source == null ? 0 : source.intValue();
		}
	}
}
