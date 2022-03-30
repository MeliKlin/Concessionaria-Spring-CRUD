package com.mercadolivre.concessionaria.services;

import com.mercadolivre.concessionaria.models.Vehicle;
import com.mercadolivre.concessionaria.repositories.ApplicationRepository;
import com.mercadolivre.concessionaria.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateVehicleService {

    private final ApplicationRepository<String, Vehicle> vehicleRepository;

    public CreateVehicleService(@Autowired VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle execute(Vehicle vehicle) {
        return this.vehicleRepository.create(vehicle);
    }

}
