 package io.springboot.vodainsure.controller;

 import io.springboot.vodainsure.entity.MotorCover;
 import jakarta.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import io.springboot.vodainsure.entity.MotorClaim;
 import io.springboot.vodainsure.service.MotorClaimService;

 import java.util.List;

 @RestController
 @RequestMapping("/motorclaim")
 public class MotorClaimController {
    

     @Autowired
     private MotorClaimService motorClaimService;

     @PostMapping("/makemotorclaim/{motorId}")
     public MotorClaim makeMotorClaim (
      @RequestBody MotorClaim motorClaim, @PathVariable Integer motorId){

         return motorClaimService.addMotorClaim( motorClaim, motorId);
     }
     @GetMapping("/getmotorclaim/{motorClaimId}")
     public MotorClaim getMotorClaim (@PathVariable Integer motorClaimId){
         return  motorClaimService.getMotorClaim(motorClaimId);
     }

     @GetMapping("getmotorclaims/{nationalId}")
     public List<MotorClaim> getMotorClaims (@PathVariable Integer nationalId){
         return motorClaimService.getMotorClaims(nationalId);
     }
 }
