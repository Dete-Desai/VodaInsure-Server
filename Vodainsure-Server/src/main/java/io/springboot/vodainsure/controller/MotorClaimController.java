 package io.springboot.vodainsure.controller;

 import io.springboot.vodainsure.entity.MotorCover;
 import jakarta.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import io.springboot.vodainsure.entity.MotorClaim;
 import io.springboot.vodainsure.service.MotorClaimService;

 import java.util.List;

 @RestController
 public class MotorClaimController {
    

     @Autowired
     private MotorClaimService motorClaimService;

     @PostMapping("/addmotorclaim/{motorId}")
     public MotorClaim makeMotorClaim (HttpSession session, @RequestBody MotorClaim motorClaim, @PathVariable Integer motorId){

         return motorClaimService.addMotorClaim(session, motorClaim, motorId);
     }
     @GetMapping("/getmotorclaim/{motorClaimId}")
     public MotorClaim getMotorCover(@PathVariable Integer motorClaimId){
         return  motorClaimService.getMotorClaim(motorClaimId);
     }

     @GetMapping("getmotorclaims/{motorId}")
     public List<MotorClaim> getMotorCovers (@PathVariable Integer motorId){
         return motorClaimService.getMotorClaims(motorId);
     }
 }
