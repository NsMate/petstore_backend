package org.petstore.service;

import com.org.petstore.endpoint.rest.model.Pet;
import java.util.List;
import java.util.Optional;
import org.petstore.mapper.PetMapper;
import org.petstore.persistence.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	private PetRepository petRepository;
	private PetMapper petMapper;

	public PetService(PetRepository petRepository, PetMapper petMapper) {
		this.petRepository = petRepository;
		this.petMapper = petMapper;
	}

	public List<Pet> getAllPets() {
		return petRepository.findAll().stream().map(petMapper::mapPetOrder).toList();
	}

	public com.org.petstore.endpoint.rest.model.Pet getPetById(Long id) {
		Optional<org.petstore.persistence.entity.Pet> pet = petRepository.findById(id);
		return petMapper.mapPetOrder(pet.get());
	}
}
