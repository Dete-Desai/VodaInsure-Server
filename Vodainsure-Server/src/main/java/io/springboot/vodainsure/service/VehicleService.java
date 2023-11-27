package io.springboot.vodainsure.service;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.exception.NotFoundException;
import io.springboot.vodainsure.repository.UserRepository;
import io.springboot.vodainsure.repository.VehicleRepository;

import java.util.Random;
@Service
public class VehicleService {
    @Autowired
    private  VehicleRepository vehicleRepository;

    public Vehicle saveVehicle (Vehicle vehicle){
      

         int randomValue ;
        do {
            randomValue = 100_000 + new Random().nextInt(900_000);
        } while (vehicleRepository.existsByvehicleid(randomValue));

        
        vehicle.setVehicleid(randomValue);
        return  vehicleRepository.save(vehicle);
    }



}

