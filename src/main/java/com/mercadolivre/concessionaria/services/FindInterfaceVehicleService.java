package com.mercadolivre.concessionaria.services;

import com.mercadolivre.concessionaria.models.Vehicle;
import com.mercadolivre.concessionaria.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindInterfaceVehicleService {

    private final VehicleRepository vehicleRepository;

    public FindInterfaceVehicleService(@Autowired VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle execute(Vehicle vehicle) {
        Optional<Vehicle> optionalVehicle = this.vehicleRepository.find(vehicle.getId());
        return optionalVehicle.orElseGet(Vehicle::new);
    }
}
