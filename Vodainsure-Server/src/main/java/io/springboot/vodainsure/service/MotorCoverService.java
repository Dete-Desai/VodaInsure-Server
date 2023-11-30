package io.springboot.vodainsure.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.MotorCover;
import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.repository.MotorCoverRepository;
public class MotorCoverService {
    

    @Autowired
    private MotorCoverRepository motorCoverRepository;

    


    public MotorCover updateMotorCoverForVehicle (MotorCover motorCover, Vehicle vehicle){
      

        int randomValue ;
       do {
           randomValue = 100_000 + new Random().nextInt(900_000);
       } while (motorCoverRepository.existsBymotorId(randomValue));

       
       motorCover.setMotorId(randomValue);
       motorCover.setVehicle(vehicle);
        MyUserDetails currentUser = MyUserDetails.getCurrentUser();
        User user = currentUser.getUser();

    //    motorCover.setUser(user);
       return  motorCoverRepository.save(motorCover);
   }

    //  @Autowired
    // private VehicleRepository vehicleRepository;

    //  @Autowired
    //  private VehicleService vehicleService;

    //     public MotorCover updateMotorCoverForVehicle() {
    //     // Integer vehicleId
        
    //     MyUserDetails currentUser = MyUserDetails.getCurrentUser();
    //     User user = currentUser.getUser();

    //     // List<Vehicle> gotvehicles = user.getVehicles ();
    //     // Vehicle fvehicle = gotvehicles.get (0);
    //         int randomValue ;
    //         do {
    //             randomValue = 100_000 + new Random().nextInt(900_000);
    //         } while (motorCoverRepository.existsBymotorId(randomValue));
            
    //         MotorCover motorCover = new MotorCover();
    //         int vehicleId = 726037;
    //         vehicleService.getVehicleByIdForCurrentUser(vehicleId, user)
    // .ifPresent(vehicle -> motorCover.setVehicle(vehicle));

    //             //  motorCover.setUser(user);
    //         //  motorCover.setVehicle(fvehicle);
    //         motorCover.setMotorId(randomValue);
           
                   
    //       return  motorCoverRepository.save(motorCover);
            
       
    // }

}
