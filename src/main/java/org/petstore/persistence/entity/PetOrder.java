package org.petstore.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "PET_ORDER")
public class PetOrder implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PET_ID")
    private Integer petId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "SHIP_DATE")
    private OffsetDateTime shipDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COMPLETE")
    private Boolean complete;
}
