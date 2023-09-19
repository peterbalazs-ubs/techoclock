package com.ubs.pbalazs.demo.quickdev1.repositories;

import com.ubs.pbalazs.demo.quickdev1.models.Address;
import com.ubs.pbalazs.demo.quickdev1.models.EmailAddress;
import com.ubs.pbalazs.demo.quickdev1.models.Person;
import com.ubs.pbalazs.demo.quickdev1.models.PhoneNumber;
import com.ubs.pbalazs.demo.quickdev1.repsitories.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;

@SpringBootTest
public class PeopleRepositoryTest {

	@Autowired
	private PeopleRepository peopleRepository;

	@Test
	public void test_store() {
		peopleRepository.store(Person.builder()
						.title("Mr.")
						.firstName("Max")
						.lastName("Muster")
						.fullName("Mr. Max Muster")
						.dateOfBirth(Date.from(
								Instant.now()
									.minus(25 * 365, ChronoUnit.DAYS)))
						.addressList(Collections.singletonList(Address.builder()
										.postalCode("8000")
										.town("Zuerich")
										.street("Flur")
										.streetNumber("66")
								.build()))
						.emailAddressList(Collections.singletonList(EmailAddress.builder()
										.emailAddress("max.muster@ubs.com")
										.secureCommunication(true)
								.build()))
						.phoneNumberList(Collections.singletonList(PhoneNumber.builder()
										.countryCode("+41")
										.localNumber("0789898989")
										.internationalFormat("+41789898989")
										.smsCapable(true)
										.whatsAppEnabled(false)
								.build()))
				.build());
	}
}
