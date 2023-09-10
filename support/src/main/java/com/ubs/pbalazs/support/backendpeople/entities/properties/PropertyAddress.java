package com.ubs.pbalazs.support.backendpeople.entities.properties;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "propertyaddresses")
public class PropertyAddress {

	@Id
	@GeneratedValue
	private UUID uuid;

	@OneToOne
	private Property property;
}
