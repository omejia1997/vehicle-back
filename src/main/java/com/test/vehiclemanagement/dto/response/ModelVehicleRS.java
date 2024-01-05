package com.test.vehiclemanagement.dto.response;

import com.test.vehiclemanagement.model.BrandVehicle;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ModelVehicleRS {
    private String name;
    private BrandVehicleRS brandVehicleRS;
    private Date creationDate;
}
