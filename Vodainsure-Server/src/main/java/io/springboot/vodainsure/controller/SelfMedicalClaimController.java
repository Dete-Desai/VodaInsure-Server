package io.springboot.vodainsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.vodainsure.entity.SelfMedicalClaim;
import io.springboot.vodainsure.service.SelfMedicalClaimService;

@RestController
public class SelfMedicalClaimController {
    
    @Autowired
    private SelfMedicalClaimService selfMedicalClaimService;
    @PostMapping("/{selfId}/updateselfclaim")
    public SelfMedicalClaim saveSelfMedicalCover (@RequestBody SelfMedicalClaim SelfMedicalClaim, @PathVariable Integer selfId){

        return selfMedicalClaimService.saveSelfMedicalClaim(SelfMedicalClaim, selfId);
    }
}
