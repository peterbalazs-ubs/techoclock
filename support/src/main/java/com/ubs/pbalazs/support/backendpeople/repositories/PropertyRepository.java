package com.ubs.pbalazs.support.backendpeople.repositories;

import com.ubs.pbalazs.support.backendpeople.entities.properties.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {
}
