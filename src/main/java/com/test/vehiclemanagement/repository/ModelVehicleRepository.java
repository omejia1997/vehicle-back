package com.test.vehiclemanagement.repository;

import com.test.vehiclemanagement.model.ModelVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelVehicleRepository extends JpaRepository<ModelVehicle, String> {
    ModelVehicle findByName(String name);
    List<ModelVehicle> findByBrandName(String name);
}
