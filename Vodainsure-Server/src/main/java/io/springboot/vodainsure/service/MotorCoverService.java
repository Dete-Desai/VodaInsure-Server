package io.springboot.vodainsure.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.MotorCover;
import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.repository.MotorCoverRepository;

@Service
public class MotorCoverService {
    

    @Autowired
    private MotorCoverRepository motorCoverRepository;

    


    public MotorCover updateMotorCoverForVehicle (MotorCover motorCover, Integer vehicleId){
        
        MyUserDetails currentUser = MyUserDetails.getCurrentUser();
        User user = currentUser.getUser();

          Optional<Vehicle> optionalVehicle = user.getVehicles().stream()
                .filter(vehicle -> vehicle.getVehicleId() == (vehicleId))
                .findFirst();
                if (optionalVehicle.isPresent()) {
                    Vehicle foundvehicle = optionalVehicle.get();

        int randomValue ;
       do {
           randomValue = 100_000 + new Random().nextInt(900_000);
       } while (motorCoverRepository.existsBymotorId(randomValue));
       motorCover.setRegistrationNumber(foundvehicle.getRegistrationNumber());
       motorCover.setMotorId(randomValue);
        motorCover.setVehicle(foundvehicle);
         motorCover.setUser(user);
                }
                else {
                    System.out.println("Vehicle not found for the authenticated user with ID: " + vehicleId); 
                }


       
       
      
   
       return  motorCoverRepository.save(motorCover);
   }

  

}

  