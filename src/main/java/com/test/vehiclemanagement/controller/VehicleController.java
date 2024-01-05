package com.test.vehiclemanagement.controller;

import com.test.vehiclemanagement.dto.request.VehicleRQ;
import com.test.vehiclemanagement.dto.response.VehicleRS;
import com.test.vehiclemanagement.mapper.VehicleMapper;
import com.test.vehiclemanagement.model.Vehicle;
import com.test.vehiclemanagement.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody VehicleRQ vehicleDto){
        try{
            Vehicle vehicle = this.vehicleService.register(VehicleMapper.buildVehicle(vehicleDto));
            return ResponseEntity.ok(VehicleMapper.buildVehicleDTO(vehicle));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    @GetMapping(path = "/list_vehicles")
    public ResponseEntity<List<VehicleRS>> listAllVehicles() {
        try {
            List<VehicleRS> vehicleRS = this.vehicleService.findAllVehicles().stream()
                            .map(vehicle -> VehicleMapper.buildVehicleDTO(vehicle))
                            .collect(Collectors.toList());
            return ResponseEntity.ok(vehicleRS);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/filter_vehicles_by_date/{purchaseDateString}")
    public ResponseEntity<?> filterVehiclesByDate(@PathVariable String purchaseDateString) {
        try {
            List<VehicleRS> vehicleRS = this.vehicleService.filterVehiclesByDate(purchaseDateString).stream()
                    .map(vehicle -> VehicleMapper.buildVehicleDTO(vehicle))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(vehicleRS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }

}
