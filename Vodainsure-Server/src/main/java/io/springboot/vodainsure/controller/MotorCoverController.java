package io.springboot.vodainsure.controller;

import io.springboot.vodainsure.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import io.springboot.vodainsure.entity.MotorCover;


import io.springboot.vodainsure.service.MotorCoverService;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@RestController
public class MotorCoverController {

     @Autowired

    private  MotorCoverService motorCoverService;
  
    @PostMapping("/addmotorcover/{vehicleId}")
    public String createMotorCoverForVehicle(HttpSession session, @RequestBody MotorCover motorCover, @PathVariable Integer vehicleId) {
       motorCoverService.addMotorCover( session
      , motorCover, vehicleId);
           return "MotorCover created successfully with ID: " + motorCover.getMotorId();
    }
    @GetMapping("/getmotorcover/{motorId}")
    public MotorCover getMotorCover(@PathVariable Integer motorId){
        return  motorCoverService.getMotorCover(motorId);
    }

    @GetMapping("getmotorcovers/{nationalId}")
    public List<MotorCover> getMotorCovers (@PathVariable Integer nationalId){
        return motorCoverService.getMotorCovers(nationalId);
    }
    
}
