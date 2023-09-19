package com.ubs.pbalazs.demo.quickdev1.repositories;

import com.ubs.pbalazs.demo.quickdev1.models.RealEstate;
import com.ubs.pbalazs.demo.quickdev1.repsitories.RealEstateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class RealEstateRepositoryTest {

	@Autowired
	private RealEstateRepository realEstateRepository;

	@Test
	public void test_store() {
		realEstateRepository.store(RealEstate.builder()
						.city("Dietikon")
						.postalCode("8900")
						.streetName("Zuercher")
						.streetNumber("80")
						.landSize(1000)
						.livingSize(120)
						.numberOfBathRooms(2)
						.numberOfToilets(2)
						.numberOfRooms(new BigDecimal("4.5"))
				.build());
	}
}
