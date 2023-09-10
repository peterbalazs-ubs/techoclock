package com.ubs.pbalazs.support.backendpeople.repositories;

import com.ubs.pbalazs.support.backendpeople.entities.people.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, UUID> {
}
