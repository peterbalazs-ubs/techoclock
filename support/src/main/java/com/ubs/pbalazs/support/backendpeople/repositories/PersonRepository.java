package com.ubs.pbalazs.support.backendpeople.repositories;

import com.ubs.pbalazs.support.backendpeople.entities.people.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
