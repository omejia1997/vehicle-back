package com.test.vehiclemanagement.controller;

import com.test.vehiclemanagement.dto.request.BrandVehicleRQ;
import com.test.vehiclemanagement.dto.response.BrandVehicleRS;
import com.test.vehiclemanagement.mapper.BrandVehicleMapper;
import com.test.vehiclemanagement.model.BrandVehicle;
import com.test.vehiclemanagement.service.BrandVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "/brand_vehicle")
@RequiredArgsConstructor
public class BrandVehicleController {
    private final BrandVehicleService brandVehicleService;

    @PostMapping("/create")
    public ResponseEntity<?> createBrand(@RequestBody BrandVehicleRQ brandVehicleDTO){
        try{
            BrandVehicle brandVehicle = this.brandVehicleService.createBrand(BrandVehicleMapper.buildBrandVehicle(brandVehicleDTO));
            return ResponseEntity.ok(BrandVehicleMapper.buildBrandVehicleRS(brandVehicle));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    @GetMapping(path = "/list_brands")
    public ResponseEntity<List<BrandVehicleRS>> listAllBrandsVehicles() {
        try {
            List<BrandVehicleRS> brandVehicleRS = this.brandVehicleService.findAllBrandsVehicles().stream()
                    .map(brandVehicle -> BrandVehicleMapper.buildBrandVehicleRS(brandVehicle))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(brandVehicleRS);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
