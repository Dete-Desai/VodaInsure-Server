 package io.springboot.vodainsure.controller;

 import io.springboot.vodainsure.entity.SelfMedicalClaim;
 import jakarta.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import io.springboot.vodainsure.entity.CorporateMedicalClaim;
 import io.springboot.vodainsure.service.CorporateMedicalClaimService;

 import java.util.List;

 @RestController
 public class CorporateMedicalClaimController {
      @Autowired
     private CorporateMedicalClaimService corporateMedicalClaimService;

     @PostMapping("/addcorporateclaim/{corporateId}")
     public CorporateMedicalClaim saveCorporateMedicalCover (HttpSession session, @RequestBody CorporateMedicalClaim corporateMedicalClaim, @PathVariable Integer corporateId){
         return corporateMedicalClaimService.saveCorporateMedicalClaim(session, corporateMedicalClaim, corporateId);
     }

     @GetMapping("/getcorporatemedicalclaim/{corporateClaimId}")
     public CorporateMedicalClaim getSelfMedicalClaim(@PathVariable Integer corporateClaimId){
         return corporateMedicalClaimService.getCorporateMedicalClaim(corporateClaimId);
     }

     @GetMapping("getcorporatemedicalclaims/{corporateId}")
     public List<CorporateMedicalClaim> getCorporateMedicalClaims (@PathVariable Integer corporateId){
         return corporateMedicalClaimService.getCorporateMedicalClaims(corporateId);
     }


 }
