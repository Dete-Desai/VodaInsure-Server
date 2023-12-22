package io.springboot.vodainsure.controller;

import io.springboot.vodainsure.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.springboot.vodainsure.ResponseBody.CreatedResponse;

import io.springboot.vodainsure.entity.MotorCover;


import io.springboot.vodainsure.service.MotorCoverService;


import java.util.List;

@RestController()
@RequestMapping("/motorcover")

public class MotorCoverController {

     @Autowired

    private  MotorCoverService motorCoverService;
     @PostMapping("/add/{vehicleId}")
public ResponseEntity<CreatedResponse> saveVehicle(@RequestBody MotorCover motorCover, @PathVariable Integer vehicleId) {
    try {
        MotorCover savedMotorCover = motorCoverService.addMotorCover(motorCover, vehicleId);
        CreatedResponse response = new CreatedResponse(HttpStatus.CREATED.value(), "Motorcover registered successfully");
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }
}
    // @PostMapping("/addmotorcover/{vehicleId}")
    // public String createMotorCoverForVehicle( @RequestBody MotorCover motorCover, @PathVariable Integer vehicleId) {
    //    motorCoverService.addMotorCover( 
    //   motorCover, vehicleId);
    //        return "MotorCover created successfully with ID: " + motorCover.getMotorId();
    // }
    @GetMapping("/getmotorcover/{motorId}")
    public MotorCover getMotorCover(@PathVariable Integer motorId){
        return  motorCoverService.getMotorCover(motorId);
    }

    @GetMapping("getmotorcovers/{nationalId}")
    public List<MotorCover> getMotorCovers (@PathVariable Integer nationalId){
        return motorCoverService.getMotorCovers(nationalId);
    }
    
}
