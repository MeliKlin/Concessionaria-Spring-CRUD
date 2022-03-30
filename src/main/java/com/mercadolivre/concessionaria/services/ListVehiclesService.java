package com.mercadolivre.concessionaria.services;

import com.mercadolivre.concessionaria.models.Vehicle;
import com.mercadolivre.concessionaria.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListVehiclesService {

    private final VehicleRepository vehicleRepository;

    public ListVehiclesService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> execute(List<Vehicle> vehicles) {
        vehicles = vehicleRepository.read();
        return vehicles;
    }
}
