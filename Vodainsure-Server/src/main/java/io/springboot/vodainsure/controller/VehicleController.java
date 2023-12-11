 package io.springboot.vodainsure.controller;

 import org.springframework.beans.factory.annotation.Autowired;
 // import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.web.bind.annotation.*;

 import io.springboot.vodainsure.entity.User;
 import io.springboot.vodainsure.entity.Vehicle;

 import io.springboot.vodainsure.service.VehicleService;
 import jakarta.servlet.http.HttpSession;

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

     @PostMapping("/register")
   
      public Vehicle addVehicle(HttpSession session, @RequestBody Vehicle vehicle) {
         return vehicleService.saveVehicle(session, vehicle);
     }
     @PutMapping("/updatevehicle/{vehicleId}")

     public Vehicle updateVehicle(@RequestBody Vehicle updatedVehicle, @PathVariable Integer vehicleId) {
         return vehicleService.updateVehicle(updatedVehicle, vehicleId);
     }
     @DeleteMapping("/vehicle/{vehicleId}")
//     @RequestMapping(method = RequestMethod.DELETE, value="/vehicle/{vehicleId}")
         public void deleteVehicle( @PathVariable Integer vehicleId) {
         vehicleService.deleteVehicle( vehicleId);
     }


 }
