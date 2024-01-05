package com.test.vehiclemanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BrandVehicleRQ {
    private String name;
    @JsonCreator
    public BrandVehicleRQ(@JsonProperty("name") String name) {
        this.name = name;
    }
}
