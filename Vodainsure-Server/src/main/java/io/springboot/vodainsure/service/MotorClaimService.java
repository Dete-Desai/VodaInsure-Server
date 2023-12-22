package io.springboot.vodainsure.service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import io.springboot.vodainsure.repository.MotorCoverRepository;
import io.springboot.vodainsure.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.config.CustomUserDetails;
// import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.MotorClaim;
import io.springboot.vodainsure.entity.MotorCover;
import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.repository.MotorClaimRepository;

@Service
public class MotorClaimService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private MotorClaimRepository motorClaimRepository;

    @Autowired
    private MotorCoverRepository motorCoverRepository;
public MotorClaim addMotorClaim ( MotorClaim motorClaim, Integer motorId){
     CustomUserDetails foundUser = CustomUserDetails.getCurrentUser();
        User currentUser = foundUser.getUser();
    User user = userRepository.findBynationalId(currentUser.getNationalId());

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

        motorClaim.setMotorId(foundMotorCover.getMotorId());
        motorClaim.setPolicyNumber(foundMotorCover.getPolicyNumber());
        motorClaim.setUser(user);
        motorClaim.setMake(coveredVehicle.getMake());
        motorClaim.setMotorClaimId(randomValue);
        motorClaim.setDriverId(coveredVehicle.getDriverId());
        motorClaim.setDriverName(coveredVehicle.getDriverName());
     }
     else{
         System.out.println("MotorCover not found for the authenticated user with ID: " + motorId);
//         return  null;
     }
    return motorClaimRepository.save(motorClaim);
}

    public MotorClaim getMotorClaim(Integer motorClaimId) {
        MotorClaim motorClaim = motorClaimRepository.findByMotorClaimId(motorClaimId);
        if (motorClaim != null){
            return motorClaim;
        }
        else {
            return null;
        }
    }
    public List<MotorClaim> getMotorClaims(Integer nationalId){

        User user = userRepository.findBynationalId(nationalId);
        if (user != null){
        List<MotorClaim> userMotorClaims = user.getMotorClaims();
            return  userMotorClaims;
        }else {
            return null;
        }

    }
}
