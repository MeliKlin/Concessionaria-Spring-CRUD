package com.mercadolivre.concessionaria.repositories;

import com.mercadolivre.concessionaria.models.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepository implements ApplicationRepository<String, Vehicle> {

    private final List<Vehicle> inMemoryDatabase;

    public VehicleRepository() {
        this.inMemoryDatabase = new ArrayList<>();
    }


    @Override
    public Vehicle create(Vehicle vehicle) {
        this.inMemoryDatabase.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> read() {
        return this.inMemoryDatabase;
    }

    @Override
    public Optional<Vehicle> find(String vehicleId) {
        return this.inMemoryDatabase
                .stream()
                .filter(vehicle -> vehicle.getId().equals(vehicleId))
                .findFirst();
    }

    @Override
    public Vehicle update(String vehicleId, Vehicle newVehicle) {
        int vehicleIndex = 0;
        boolean exists = false;

        for (Vehicle vehicle: this.inMemoryDatabase) {
            if (vehicle.getId().equals(vehicleId)) {
                exists = true;
                break;
            }
            vehicleIndex++;
        }

        if (exists) {
            this.inMemoryDatabase.set(vehicleIndex, newVehicle);
            return newVehicle;
        }

        return new Vehicle();
    }

    @Override
    public void delete(Vehicle vehicle) {
        this.inMemoryDatabase.remove(vehicle);
    }
}
