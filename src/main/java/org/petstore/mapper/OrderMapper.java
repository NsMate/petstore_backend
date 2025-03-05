package org.petstore.mapper;

import com.org.petstore.endpoint.rest.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.petstore.persistence.entity.PetOrder;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "petId", source = "petId")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "shipDate", source = "shipDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "complete", source = "complete")
    Order mapOrder(PetOrder petOrder);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "petId", source = "petId")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "shipDate", source = "shipDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "complete", source = "complete")
    PetOrder mapPetOrder(Order order);

    default Order.StatusEnum orderStatusFromString(String status){
        return Order.StatusEnum.fromValue(status);
    }

    default String orderStatusFromEnum(Order.StatusEnum statusEnum){
        return statusEnum.toString();
    }
}
