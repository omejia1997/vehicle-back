package com.test.vehiclemanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.vehiclemanagement.dto.response.PriceApiRS;
import com.test.vehiclemanagement.model.ModelVehicle;
import com.test.vehiclemanagement.model.Vehicle;
import com.test.vehiclemanagement.repository.ModelVehicleRepository;
import com.test.vehiclemanagement.repository.VehicleRepository;
import com.test.vehiclemanagement.utils.Holiday;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final String apiUrl = "https://auto.jedai.workers.dev";
    private final VehicleRepository vehicleRepository;
    private final ModelVehicleRepository modelVehicleRepository;
    private final RestTemplate restTemplate;

    public Vehicle register(Vehicle vehicle) throws Exception {
        Vehicle vehicleValidate = this.vehicleRepository.findByPlate(vehicle.getPlate());
        if (vehicleValidate != null) throw new Exception("Este auto con esta placa ya existe");
        ModelVehicle modelVehicle = this.modelVehicleRepository.findByName(vehicle.getModel().getName());
        vehicle.setModel(modelVehicle);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(this.apiUrl + "?placa=" + vehicle.getPlate(), String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                PriceApiRS priceApiRS = objectMapper.readValue(responseBody, PriceApiRS.class);
                vehicle.setPrice(priceApiRS.getPrecio());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Error en la solicitud: " + responseEntity.getStatusCodeValue());
        }
        return this.vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findAllVehicles() {
        return this.vehicleRepository.findAll();
    }

    public List<Vehicle> filterVehiclesByDate(String purchaseDateString) throws Exception {
        for (String holidays: Holiday.getHolidays()) {
            if(holidays.equals(purchaseDateString)) throw new Exception("Este día es feriado");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date purchaseDateMax = dateFormat.parse(purchaseDateString);

        if(this.validateWeekendDate(purchaseDateMax)) throw new Exception("Este día es fin de semana y no se trabaja");

        long sixtyDaysInMillis = 60 * 24 * 60 * 60 * 1000L;
        Date minDate = new Date(purchaseDateMax.getTime() - sixtyDaysInMillis);
        return this.vehicleRepository.findVehiclesWithPurchaseDateInRange(purchaseDateMax,minDate);
    }

    private boolean validateWeekendDate(Date dateValidate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateValidate);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        boolean isWeekend = (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
        if (isWeekend) return true;
        return false;
    }
}
