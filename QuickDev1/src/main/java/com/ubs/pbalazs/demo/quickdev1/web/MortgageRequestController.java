package com.ubs.pbalazs.demo.quickdev1.web;

import com.ubs.pbalazs.demo.quickdev1.api.MortgageRequestApi;
import com.ubs.pbalazs.demo.quickdev1.api.models.MortgageRequest;
import com.ubs.pbalazs.demo.quickdev1.mappers.mapstruct.MapstructMappers;
import com.ubs.pbalazs.demo.quickdev1.models.Person;
import com.ubs.pbalazs.demo.quickdev1.models.RealEstate;
import com.ubs.pbalazs.demo.quickdev1.repsitories.PeopleRepository;
import com.ubs.pbalazs.demo.quickdev1.repsitories.RealEstateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MortgageRequestController implements MortgageRequestApi {

	private final PeopleRepository peopleRepository;

	private final RealEstateRepository realEstateRepository;

	private final MapstructMappers mapstructMappers;

	private final MapperFacade mapperFacade;

	@Override
	public ResponseEntity<Void> mortgageRequest(@RequestBody MortgageRequest mortgageRequest) {
		// mapstruct
		final var personMapstruct = mapstructMappers.toPerson(mortgageRequest.getRequester());
		final var realEstateMapstruct = mapstructMappers.toRealEstate(mortgageRequest.getProperty());

		log.info("Mapstruct Person: {}", personMapstruct);
		log.info("Mapstruct Real Estate: {}", realEstateMapstruct);

		// orika
		final var personOrika = mapperFacade.map(mortgageRequest.getRequester(), Person.class);
		final var realEstateOrika = mapperFacade.map(mortgageRequest.getProperty(), RealEstate.class);
		log.info("Orika Person:     {}", personOrika);
		log.info("Orika Real Estate:     {}", realEstateOrika);

		peopleRepository.store(personMapstruct);
		realEstateRepository.store(realEstateMapstruct);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
