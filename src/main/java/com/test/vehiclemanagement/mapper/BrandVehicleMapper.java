package com.test.vehiclemanagement.mapper;

import com.test.vehiclemanagement.dto.request.BrandVehicleRQ;
import com.test.vehiclemanagement.dto.request.ModelVehicleRQ;
import com.test.vehiclemanagement.dto.response.BrandVehicleRS;
import com.test.vehiclemanagement.model.BrandVehicle;
import com.test.vehiclemanagement.model.ModelVehicle;

public class BrandVehicleMapper {
    public static BrandVehicle buildBrandVehicle(BrandVehicleRQ dto) {
        return BrandVehicle.builder()
                .name(dto.getName())
                .build();
    }

    public static BrandVehicleRS buildBrandVehicleRS(BrandVehicle brandVehicle) {
        return BrandVehicleRS.builder()
                .name(brandVehicle.getName())
                .creationDate(brandVehicle.getCreationDate())
                .build();
    }

}
