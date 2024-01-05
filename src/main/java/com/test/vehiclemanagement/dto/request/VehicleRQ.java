package com.test.vehiclemanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.vehiclemanagement.model.BrandVehicle;
import com.test.vehiclemanagement.model.ModelVehicle;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VehicleRQ {
    private String plate;
    private Integer year;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;
    private String observations;
    private ModelVehicleRQ modelVehicleRQ;
}
