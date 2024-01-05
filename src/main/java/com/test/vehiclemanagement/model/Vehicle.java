package com.test.vehiclemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "VEHICLE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "year")
    private Integer year;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "observations")
    private String observations;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "fk_id_model")
    private ModelVehicle model;
}
