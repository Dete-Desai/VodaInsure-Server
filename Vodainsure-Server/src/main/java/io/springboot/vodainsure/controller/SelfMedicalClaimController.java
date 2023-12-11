 package io.springboot.vodainsure.controller;

 import io.springboot.vodainsure.entity.MotorClaim;
 import jakarta.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import io.springboot.vodainsure.entity.SelfMedicalClaim;
 import io.springboot.vodainsure.service.SelfMedicalClaimService;

 import java.util.List;

 @RestController
 public class SelfMedicalClaimController {
    
     @Autowired
     private SelfMedicalClaimService selfMedicalClaimService;
     @PostMapping("/addselfclaim/{selfId}")
     public SelfMedicalClaim saveSelfMedicalCover (HttpSession session, @RequestBody SelfMedicalClaim SelfMedicalClaim, @PathVariable Integer selfId){

         return selfMedicalClaimService.saveSelfMedicalClaim(session, SelfMedicalClaim, selfId);
     }
     @GetMapping("/getselfmedicalclaim/{selfClaimId}")
     public SelfMedicalClaim getSelfMedicalClaim(@PathVariable Integer selfClaimId){
         return selfMedicalClaimService.getSelfMedicalClaim(selfClaimId);
     }

     @GetMapping("getselfmedicalclaims/{selfId}")
     public List<SelfMedicalClaim> getSelfMedicalClaims (@PathVariable Integer selfId){
         return selfMedicalClaimService.getSelfMedicalClaims(selfId);
     }
 }
