package com.test.vehiclemanagement.mapper;

import com.test.vehiclemanagement.dto.request.ModelVehicleRQ;
import com.test.vehiclemanagement.dto.response.ModelVehicleRS;
import com.test.vehiclemanagement.model.ModelVehicle;

public class ModelVehicleMapper {
    public static ModelVehicle buildModelVehicle(ModelVehicleRQ dto) {
        return ModelVehicle.builder()
                .name(dto.getName())
                .brand(BrandVehicleMapper.buildBrandVehicle(dto.getBrandVehicleRQ()))
                .build();
    }

    public static ModelVehicleRS buildModelVehicleRS(ModelVehicle modelVehicle) {
        return ModelVehicleRS.builder()
                .name(modelVehicle.getName())
                .creationDate(modelVehicle.getCreationDate())
                .brandVehicleRS(BrandVehicleMapper.buildBrandVehicleRS(modelVehicle.getBrand()))
                .build();
    }

}
