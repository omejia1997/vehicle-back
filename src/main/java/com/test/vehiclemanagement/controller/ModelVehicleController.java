package com.test.vehiclemanagement.controller;

import com.test.vehiclemanagement.dto.request.ModelVehicleRQ;
import com.test.vehiclemanagement.dto.response.ModelVehicleRS;
import com.test.vehiclemanagement.mapper.ModelVehicleMapper;
import com.test.vehiclemanagement.model.ModelVehicle;
import com.test.vehiclemanagement.service.ModelVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "/model_vehicle")
@RequiredArgsConstructor
public class ModelVehicleController {
    private final ModelVehicleService modelVehicleService;

    @PostMapping("/create")
    public ResponseEntity<?> createModel(@RequestBody ModelVehicleRQ modelVehicleDto){
        try{
            ModelVehicle modelVehicle = this.modelVehicleService.createModel(ModelVehicleMapper.buildModelVehicle(modelVehicleDto));
            return ResponseEntity.ok(ModelVehicleMapper.buildModelVehicleRS(modelVehicle));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    @GetMapping(path = "/list_models/{nameBrand}")
    public ResponseEntity<List<ModelVehicleRS>> listAllModelsVehicles(@PathVariable String nameBrand) {
        try {
            List<ModelVehicleRS> modelVehiclesRS = this.modelVehicleService.findAllModelsVehiclesByBrand(nameBrand).stream()
                    .map(vehicle -> ModelVehicleMapper.buildModelVehicleRS(vehicle))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(modelVehiclesRS);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
