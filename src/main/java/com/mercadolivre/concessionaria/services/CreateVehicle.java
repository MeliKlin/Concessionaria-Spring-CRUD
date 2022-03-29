package com.mercadolivre.concessionaria.services;

import com.mercadolivre.concessionaria.models.Vehicle;
import com.mercadolivre.concessionaria.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateVehicle implements VehicleCommands<Vehicle> {

    private final VehicleRepository vehicleRepository;

    public CreateVehicle(@Autowired  VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle execute(Vehicle vehicle) {
        return this.vehicleRepository.create(vehicle);
    }

}
