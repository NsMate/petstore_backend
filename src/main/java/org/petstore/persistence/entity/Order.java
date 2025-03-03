package org.petstore.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "PET_ORDER")
public class Order implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PET_ID")
    private Integer petId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "SHIP_DATE")
    private String shipDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COMPLETE")
    private Boolean complete;
}
