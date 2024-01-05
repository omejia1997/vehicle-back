package com.test.vehiclemanagement.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BrandVehicleRS {
    private String name;
    private Date creationDate;
}
