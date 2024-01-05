package com.test.vehiclemanagement.service;

import com.test.vehiclemanagement.model.BrandVehicle;
import com.test.vehiclemanagement.model.ModelVehicle;
import com.test.vehiclemanagement.repository.BrandVehicleRepository;
import com.test.vehiclemanagement.repository.ModelVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandVehicleService {
    private final BrandVehicleRepository brandVehicleRepository;

    public BrandVehicle createBrand(BrandVehicle brandVehicle) throws Exception {
        brandVehicle.setName(brandVehicle.getName().toUpperCase());
        BrandVehicle brandVehicleSearch = this.brandVehicleRepository.findByName(brandVehicle.getName());
        if(brandVehicleSearch != null) throw new Exception("Esta marca ya existe");
        brandVehicle.setCreationDate(new Date());
        return this.brandVehicleRepository.save(brandVehicle);
    }

    public List<BrandVehicle> findAllBrandsVehicles(){
        return this.brandVehicleRepository.findAll();
    }
}
