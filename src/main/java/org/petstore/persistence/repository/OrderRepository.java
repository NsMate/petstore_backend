package org.petstore.persistence.repository;

import org.petstore.persistence.entity.PetOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PetOrder, Long> {
}
