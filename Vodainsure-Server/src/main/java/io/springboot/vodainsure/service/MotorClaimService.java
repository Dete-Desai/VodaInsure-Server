package io.springboot.vodainsure.service;


import java.util.List;
import java.util.Optional;
import java.util.Random;

import io.springboot.vodainsure.repository.MotorCoverRepository;
import io.springboot.vodainsure.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public MotorClaim addMotorClaim (HttpSession session, MotorClaim motorClaim, Integer motorId){
    User currentUser = (User) session.getAttribute("user");
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

        motorClaim.setMotorCover(foundMotorCover);
        motorClaim.setNationalId(user.getNationalId());
        motorClaim.setCoverType(foundMotorCover.getCoverType());
        motorClaim.setPolicyNumber(foundMotorCover.getPolicyNumber());
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
    public List<MotorClaim> getMotorClaims(Integer motorId){
        MotorCover motorCover = motorCoverRepository.findByMotorId(motorId);
        if (motorCover != null){
            List<MotorClaim> userMotorClaims = motorCover.getMotorClaims();
            return  userMotorClaims;
        }else {
            return null;
        }

    }
}
