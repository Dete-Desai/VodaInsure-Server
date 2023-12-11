 package io.springboot.vodainsure.service;
 import org.springframework.beans.factory.annotation.Autowired;
 // import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

import io.springboot.vodainsure.config.CustomUserDetails;
// import io.springboot.vodainsure.config.MyUserDetails;
 import io.springboot.vodainsure.entity.User;
 import io.springboot.vodainsure.entity.Vehicle;
 import io.springboot.vodainsure.repository.UserRepository;
 import io.springboot.vodainsure.repository.VehicleRepository;
 import jakarta.servlet.http.HttpSession;

 import java.util.List;
 import java.util.Random;
 @Service
 @Transactional
 public class VehicleService {
     @Autowired
     private  VehicleRepository vehicleRepository;

     @Autowired
     private UserRepository userRepository;

   
     public Vehicle saveVehicle (HttpSession session, Vehicle vehicle){
      

          int randomValue ;
         do {
             randomValue = 100_000 + new Random().nextInt(900_000);
         } while (vehicleRepository.existsByvehicleId(randomValue));

        
         vehicle.setVehicleId(randomValue);
        
         CustomUserDetails currentUser = CustomUserDetails.getCurrentUser();
        User foundUser = currentUser.getUser();
         User user = userRepository.findBynationalId(foundUser.getNationalId());
         vehicle.setUser(user);
         return  vehicleRepository.save(vehicle);
     }
     public Vehicle getVehicle(Integer vehicleId) {
        Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId);
        if (vehicle != null){
            return vehicle;
        }
        else {
            return null;
        }
     }
     public List<Vehicle> getVehicles(Integer nationalId){
         User user = userRepository.findBynationalId(nationalId);
         if (user != null){
             List<Vehicle> userVehicles = user.getVehicles();
             return  userVehicles;
         }else {
             return null;
         }

     }


     public Vehicle updateVehicle( Vehicle updatedVehicle, Integer vehicleId) {

            Vehicle existingVehicle = vehicleRepository.findById(vehicleId).orElse(null);

             if (existingVehicle != null) {

                 existingVehicle.setRegistrationNumber(updatedVehicle.getRegistrationNumber());
                 existingVehicle.setChasisNumber(updatedVehicle.getChasisNumber());
                 existingVehicle.setCvNumber(updatedVehicle.getCvNumber());
                 existingVehicle.setVehicleValue(updatedVehicle.getVehicleValue());
                 existingVehicle.setManufactureYear(updatedVehicle.getManufactureYear());
                 existingVehicle.setDriverId(updatedVehicle.getDriverId());
                 existingVehicle.setMake(updatedVehicle.getMake());
                 existingVehicle.setDriverName(updatedVehicle.getDriverName());
                 existingVehicle.setDriverExperience(updatedVehicle.getDriverExperience());




                 User user = existingVehicle.getUser();
                 if (user != null) {

                     user.getVehicles().removeIf(v -> v.getVehicleId() ==(existingVehicle.getVehicleId()));

                     user.getVehicles().add(existingVehicle);
                     userRepository.save(user);
                 }

                 return  vehicleRepository.save(existingVehicle);


             } else {

                 return  null;
             }


     }

     public void deleteVehicle(Integer vehicleId) {
         try {
             Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);

             if (vehicle != null) {

                 User user = vehicle.getUser();
                 if (user != null) {
                     user.getVehicles().remove(vehicle);
                     userRepository.save(user);
                 }

                 vehicleRepository.deleteById(vehicleId);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }



 }




