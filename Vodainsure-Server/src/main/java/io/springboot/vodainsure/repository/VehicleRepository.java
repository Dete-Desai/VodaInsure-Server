package io.springboot.vodainsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot.vodainsure.entity.Vehicle;
@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle, Integer>{

    boolean existsByvehicleId(Integer vehicleId);
    Vehicle findByVehicleId(Integer VehicleId);
} 