package io.springboot.vodainsure.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.config.CustomUserDetails;
// import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.MotorCover;
import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.repository.MotorCoverRepository;
import io.springboot.vodainsure.repository.UserRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class MotorCoverService {
    

    @Autowired
    private MotorCoverRepository motorCoverRepository;

      @Autowired
    private UserRepository userRepository;

    


    public MotorCover addMotorCover ( MotorCover motorCover, Integer vehicleId){
         CustomUserDetails foundUser = CustomUserDetails.getCurrentUser();
        User currentUser = foundUser.getUser();
        User user = userRepository.findBynationalId(currentUser.getNationalId());


           Optional<Vehicle> optionalVehicle = user.getVehicles().stream()
                 .filter(vehicle -> vehicle.getVehicleId() == (vehicleId))
                 .findFirst();
                 if (optionalVehicle.isPresent()) {
                     Vehicle foundvehicle = optionalVehicle.get();

         int randomValue ;
        do {
            randomValue = 100_000 + new Random().nextInt(900_000);
        } while (motorCoverRepository.existsBymotorId(randomValue));
        
         String randomString;
        do {
            randomValue = 100_000 + new Random().nextInt(900_000);
           randomString = "VIM" + String.valueOf(100_000 + new Random().nextInt(900_000));
            
         } while (motorCoverRepository.existsBypolicyNumber(randomString));

motorCover.setPolicyNumber(randomString);
        motorCover.setRegistrationNumber(foundvehicle.getRegistrationNumber());
        motorCover.setMotorId(randomValue);
         motorCover.setVehicle(foundvehicle);
          motorCover.setUser(user);
                 }
                 else {
                 }
      
   
       return  motorCoverRepository.save(motorCover);
   }

    public MotorCover getMotorCover(Integer motorId) {
        MotorCover motorCover = motorCoverRepository.findByMotorId(motorId);
        if (motorCover != null){
            return motorCover;
        }
        else {
            return null;
        }
    }
    public List<MotorCover> getMotorCovers(Integer nationalId){
        User user = userRepository.findBynationalId(nationalId);
        if (user != null){
            List<MotorCover> userMotorCovers = user.getMotorCovers();
            return  userMotorCovers;
        }else {
            return null;
        }

    }

}

  