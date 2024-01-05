package com.test.vehiclemanagement.mapper;

import com.test.vehiclemanagement.dto.request.VehicleRQ;
import com.test.vehiclemanagement.dto.response.VehicleRS;
import com.test.vehiclemanagement.model.Vehicle;

public class VehicleMapper {
    public static Vehicle buildVehicle(VehicleRQ dto) {
        return Vehicle.builder()
                .plate(dto.getPlate())
                .year(dto.getYear())
                .purchaseDate(dto.getPurchaseDate())
                .observations(dto.getObservations())
                .model(ModelVehicleMapper.buildModelVehicle(dto.getModelVehicleRQ()))
                .build();
    }

    public static VehicleRS buildVehicleDTO(Vehicle vehicle) {
        return VehicleRS.builder()
                .plate(vehicle.getPlate())
                .year(vehicle.getYear())
                .purchaseDate(vehicle.getPurchaseDate())
                .observations(vehicle.getObservations())
                .price(vehicle.getPrice())
                .modelVehicleRS(ModelVehicleMapper.buildModelVehicleRS(vehicle.getModel()))
                .build();
    }
}
