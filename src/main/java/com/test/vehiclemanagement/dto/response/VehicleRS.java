package com.test.vehiclemanagement.dto.response;

import com.test.vehiclemanagement.model.BrandVehicle;
import com.test.vehiclemanagement.model.ModelVehicle;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class VehicleRS {
    private String plate;
    private Integer year;
    private Date purchaseDate;
    private String observations;
    private ModelVehicleRS modelVehicleRS;
    private BigDecimal price;
}
