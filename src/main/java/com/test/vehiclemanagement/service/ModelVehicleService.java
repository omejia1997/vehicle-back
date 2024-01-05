package com.test.vehiclemanagement.service;

import com.test.vehiclemanagement.model.BrandVehicle;
import com.test.vehiclemanagement.model.ModelVehicle;
import com.test.vehiclemanagement.model.Vehicle;
import com.test.vehiclemanagement.repository.BrandVehicleRepository;
import com.test.vehiclemanagement.repository.ModelVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelVehicleService {
    private final ModelVehicleRepository modelVehicleRepository;
    private final BrandVehicleRepository brandeVehicleRepository;

    public ModelVehicle createModel(ModelVehicle modelVehicle) throws Exception {
        modelVehicle.setName(modelVehicle.getName().toUpperCase());
        ModelVehicle modelVehicleSearch = this.modelVehicleRepository.findByName(modelVehicle.getName());
        if(modelVehicleSearch != null) throw new Exception("Este nombre de modelo ya existe");
        BrandVehicle brandVehicle = this.brandeVehicleRepository.findByName(modelVehicle.getBrand().getName());
        if(brandVehicle == null) throw new Exception("Esta marca aun no está registrada");
        modelVehicle.setBrand(brandVehicle);
        modelVehicle.setCreationDate(new Date());
        return this.modelVehicleRepository.save(modelVehicle);
    }

    public List<ModelVehicle> findAllModelsVehiclesByBrand(String nameBrand) {
        return this.modelVehicleRepository.findByBrandName(nameBrand);
    }
}
