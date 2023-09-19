package com.ubs.pbalazs.demo.quickdev1.repsitories;

import com.ubs.pbalazs.demo.quickdev1.models.RealEstate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "real-estate", url = "${quickdev1.repositories.realEstate.url}")
public interface RealEstateRepository {

	@PostMapping
	void store(RealEstate realEstate);
}
