 package io.springboot.vodainsure.controller;

 import io.springboot.vodainsure.entity.MotorCover;
 import jakarta.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 // import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.web.bind.annotation.*;

 import io.springboot.vodainsure.entity.SelfMedicalCover;
 import io.springboot.vodainsure.service.SelfMedicalCoverService;

 import java.util.List;

 @RestController
 public class SelfMedicalCoverController {
    
     @Autowired
     private SelfMedicalCoverService selfMedicalCoverService;

     @PostMapping("/addselfcover")
     // @PreAuthorize("hasAuthority('ROLE_USER')")
     public SelfMedicalCover addSelfMedicalCover (HttpSession session, @RequestBody SelfMedicalCover selfMedicalCover){
       

        return selfMedicalCoverService.saveSelfMedicalCover(session, selfMedicalCover);

//         return "self cover added succesfully";
        
     }
     @GetMapping("/getselfmedicalcover/{selfId}")
     public SelfMedicalCover getSelfMedicalCover(@PathVariable Integer selfId){
         return  selfMedicalCoverService.getSelfMedicalCover(selfId);
     }

     @GetMapping("getselfmedicalcovers/{nationalId}")
     public List<SelfMedicalCover> getSelfMedicalCovers (@PathVariable Integer nationalId){
         return selfMedicalCoverService.getSelfMedicalCovers(nationalId);
     }

 }
