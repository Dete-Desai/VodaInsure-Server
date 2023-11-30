package io.springboot.vodainsure.service;


import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.MotorClaim;
import io.springboot.vodainsure.entity.MotorCover;
import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.repository.MotorClaimRepository;

@Service
public class MotorClaimService {
    
@Autowired
private MotorClaimRepository motorClaimRepository;

public MotorClaim saveMotorClaim (MotorClaim motorClaim, Integer motorId){


    MyUserDetails currentUser = MyUserDetails.getCurrentUser();
    User user = currentUser.getUser();

    
     Optional<MotorCover> optionalMotorCover = user.getMotorCovers().stream()
                .filter(motorCover -> motorCover.getMotorId() == (motorId))
                .findFirst();
                if (optionalMotorCover.isPresent()) {
                    MotorCover foundMotorCover = optionalMotorCover.get();
                    Vehicle coveredVehicle = foundMotorCover.getVehicle();
  int randomValue ;
       do {
           randomValue = 100_000 + new Random().nextInt(900_000);
       } while (motorClaimRepository.existsBymotorClaimId(randomValue));

       motorClaim.setCoverType(foundMotorCover.getCoverType());
       motorClaim.setPolicyNumber(foundMotorCover.getPolicyNumber());
       motorClaim.setVehicleCategory(coveredVehicle.getVehicleCategory());
       motorClaim.setMotorClaimId(randomValue);
       motorClaim.setDriverId(coveredVehicle.getDriverId());
       motorClaim.setDriverName(coveredVehicle.getDriverName());
    }
    else{
        System.out.println("MotorCover not found for the authenticated user with ID: " + motorId);
    }
    return motorClaimRepository.save(motorClaim);
}

}
