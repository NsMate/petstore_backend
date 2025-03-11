package org.petstore.mapper;

import com.org.petstore.endpoint.rest.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {

	@Mapping(target = "id", source = "id")
	@Mapping(target = "name", source = "name")
	@Mapping(target = "status", source = "status")
	Pet mapPetOrder(org.petstore.persistence.entity.Pet pet);

	default Pet.StatusEnum petStatusFromString(String status) {
		return Pet.StatusEnum.fromValue(status);
	}

	default String petStatusFromEnum(Pet.StatusEnum statusEnum) {
		return statusEnum.toString();
	}
}
