package com.test.vehiclemanagement.dto.response;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PriceApiRS {
    private String placa;
    private BigDecimal precio;
}
