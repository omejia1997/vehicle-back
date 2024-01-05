package com.test.vehiclemanagement.repository;

import com.test.vehiclemanagement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Vehicle findByPlate(String plate);

    @Query("SELECT v FROM Vehicle v WHERE v.purchaseDate <= :maxDate AND v.purchaseDate >= :minDate")
    List<Vehicle> findVehiclesWithPurchaseDateInRange(@Param("maxDate") Date maxDate, @Param("minDate") Date minDate);

}
