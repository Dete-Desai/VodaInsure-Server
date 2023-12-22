 package io.springboot.vodainsure.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

 import org.springframework.web.bind.annotation.*;

import io.springboot.vodainsure.ResponseBody.VehicleResponse;

 import io.springboot.vodainsure.entity.Vehicle;

 import io.springboot.vodainsure.service.VehicleService;
 

 import java.util.List;

 @RestController
 @RequestMapping("/vehicle")
 public class VehicleController {
     @Autowired
     private VehicleService vehicleService;


     @GetMapping("/getvehicle/{vehicleId}")
     public  Vehicle getVehicle(@PathVariable Integer vehicleId){
         return  vehicleService.getVehicle(vehicleId);
     }
     @GetMapping("getvehicles/{nationalId}")
     public List<Vehicle> getVehicles (@PathVariable Integer nationalId){
         return vehicleService.getVehicles(nationalId);
     }  

     @PostMapping("/register1")
   
      public Vehicle addVehicle( @RequestBody Vehicle vehicle) {
         return vehicleService.saveVehicle( vehicle);
     }
  
    @PostMapping("/register")
public ResponseEntity<VehicleResponse> saveVehicle(@RequestBody Vehicle vehicle) {
    try {
        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
        VehicleResponse response = new VehicleResponse(HttpStatus.CREATED.value(), "Registered vehicle successfully");
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }
}
     @PutMapping("/updatevehicle/{vehicleId}")

     public Vehicle updateVehicle(@RequestBody Vehicle updatedVehicle, @PathVariable Integer vehicleId) {
         return vehicleService.updateVehicle(updatedVehicle, vehicleId);
     }
     @DeleteMapping("/vehicle/{vehicleId}")

         public void deleteVehicle( @PathVariable Integer vehicleId) {
         vehicleService.deleteVehicle( vehicleId);
     }


 }
