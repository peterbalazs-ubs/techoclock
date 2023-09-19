package com.ubs.pbalazs.demo.quickdev1.repsitories;

import com.ubs.pbalazs.demo.quickdev1.models.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "people", url = "${quickdev1.repositories.people.url}")
public interface PeopleRepository {

	@PostMapping
	void store(Person person);
}
