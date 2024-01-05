package com.test.vehiclemanagement.dto.request;

import com.test.vehiclemanagement.model.BrandVehicle;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ModelVehicleRQ {
    private String name;
    private BrandVehicleRQ brandVehicleRQ;
}
