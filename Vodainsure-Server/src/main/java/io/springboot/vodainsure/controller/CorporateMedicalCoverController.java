 package io.springboot.vodainsure.controller;

 import io.springboot.vodainsure.entity.SelfMedicalCover;
 import jakarta.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 // import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.web.bind.annotation.*;

 import io.springboot.vodainsure.entity.CorporateMedicalCover;

 import io.springboot.vodainsure.service.CorporateMedicalCoverService;

 import java.util.List;

 @RestController
 public class CorporateMedicalCoverController {
      @Autowired
     private CorporateMedicalCoverService corporateMedicalCoverService;

     @PostMapping("/addcorporatecover")
     // @PreAuthorize("hasAuthority('ROLE_USER')")
     public CorporateMedicalCover addcorporateMedicalCover (HttpSession session, @RequestBody CorporateMedicalCover corporateMedicalCover){
         return corporateMedicalCoverService.saveCorporateMedicalCover(session, corporateMedicalCover);
     }
     @GetMapping("/getcorporatemedicalcover/{corporateId}")
     public CorporateMedicalCover getCorporateMedicalCover(@PathVariable Integer corporateId){
         return  corporateMedicalCoverService.getCorporateMedicalCover(corporateId);
     }

     @GetMapping("getcorporatemedicalcovers/{nationalId}")
     public List<CorporateMedicalCover> getCorporateMedicalCovers (@PathVariable Integer nationalId){
         return corporateMedicalCoverService.getCorporateMedicalCovers(nationalId);
     }
 }
