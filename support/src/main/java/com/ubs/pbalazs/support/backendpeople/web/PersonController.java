package com.ubs.pbalazs.support.backendpeople.web;

import com.ubs.pbalazs.support.backendpeople.entities.people.Person;
import com.ubs.pbalazs.support.backendpeople.repositories.EmailAddressRepository;
import com.ubs.pbalazs.support.backendpeople.repositories.PersonAddressRepository;
import com.ubs.pbalazs.support.backendpeople.repositories.PersonRepository;
import com.ubs.pbalazs.support.backendpeople.repositories.PhoneNumberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/people")
public class PersonController {
	private final EmailAddressRepository emailAddressRepository;

	private final PersonRepository personRepository;

	private final PersonAddressRepository personAddressRepository;

	private final PhoneNumberRepository phoneNumberRepository;

	@GetMapping
	public List<Person> list() {
		return personRepository.findAll();
	}

	@PostMapping
	public Person add(@RequestBody final Person person) {
		final var savedPerson = personRepository.save(person);
		if (savedPerson.getAddressList() != null) {
			savedPerson.getAddressList().forEach(a -> {
				a.setPerson(savedPerson);
				personAddressRepository.save(a);
			});
		}
		if (savedPerson.getPhoneNumberList() != null) {
			savedPerson.getPhoneNumberList().forEach(pn -> {
				pn.setPerson(savedPerson);
				phoneNumberRepository.save(pn);
			});
		}
		if (savedPerson.getEmailAddressList() != null) {
			savedPerson.getEmailAddressList().forEach(ea -> {
				ea.setPerson(savedPerson);
				emailAddressRepository.save(ea);
			});
		}

		final var details = personRepository.findById(savedPerson.getUuid()).get();

		return details;
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Person> details(@PathVariable final UUID uuid) {
		return ResponseEntity.of(personRepository.findById(uuid));
	}


	@DeleteMapping("/{uuid}")
	public ResponseEntity<Void> delete(@PathVariable final UUID uuid) {
		final var personOp = personRepository.findById(uuid);

		if (personOp.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		personRepository.deleteById(uuid);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
