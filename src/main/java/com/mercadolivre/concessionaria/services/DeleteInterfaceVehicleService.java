package com.mercadolivre.concessionaria.services;

import com.mercadolivre.concessionaria.models.Vehicle;
import com.mercadolivre.concessionaria.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteInterfaceVehicleService {

    private final VehicleRepository vehicleRepository;

    public DeleteInterfaceVehicleService(@Autowired VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void execute(Vehicle vehicle) {
        this.vehicleRepository.delete(vehicle);
    }

}
