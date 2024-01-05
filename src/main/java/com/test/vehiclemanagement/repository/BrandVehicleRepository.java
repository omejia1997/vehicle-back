package com.test.vehiclemanagement.repository;

import com.test.vehiclemanagement.model.BrandVehicle;
import com.test.vehiclemanagement.model.ModelVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandVehicleRepository extends JpaRepository<BrandVehicle, String> {
    BrandVehicle findByName(String name);
}
