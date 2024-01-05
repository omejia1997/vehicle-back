package com.test.vehiclemanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "MODEL_VEHICLE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ModelVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_id_brand")
    private BrandVehicle brand;

    @Column(name = "creation_date")
    private Date creationDate;
}
