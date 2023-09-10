package com.ubs.pbalazs.support.backendpeople.web;

import com.ubs.pbalazs.support.backendpeople.entities.properties.Property;
import com.ubs.pbalazs.support.backendpeople.repositories.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/real-estate")
public class PropertyController {

	private final PropertyRepository propertyRepository;

	@GetMapping
	public List<Property> list() {
		return propertyRepository.findAll();
	}

	@PostMapping
	public Property add(@RequestBody Property property) {
		return propertyRepository.save(property);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Property> details(@PathVariable final UUID uuid) {
		return ResponseEntity.of(propertyRepository.findById(uuid));
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<Void> delete(@PathVariable final UUID uuid) {
		final var propertyOp = propertyRepository.findById(uuid);
		if (propertyOp.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		propertyRepository.delete(propertyOp.get());

		return ResponseEntity.noContent().build();
	}
}
