package io.springboot.vodainsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.vodainsure.entity.SelfMedicalCover;
import io.springboot.vodainsure.service.SelfMedicalCoverService;

@RestController
public class SelfMedicalCoverController {
    
    @Autowired
    private SelfMedicalCoverService selfMedicalCoverService;

    @PostMapping("/addselfcover")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String addSelfMedicalCover (@RequestBody SelfMedicalCover selfMedicalCover){
       

        selfMedicalCoverService.saveSelfMedicalCover(selfMedicalCover);

        return "self cover added succesfully";
        
    }

}
