package io.springboot.vodainsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.vodainsure.entity.CorporateMedicalClaim;
import io.springboot.vodainsure.service.CorporateMedicalClaimService;

@RestController
public class CorporateMedicalClaimController {
     @Autowired
    private CorporateMedicalClaimService corporateMedicalClaimService;

    @PostMapping("/{corporateId}/updatecorporateclaim")
    public CorporateMedicalClaim saveCorporateMedicalCover (@RequestBody CorporateMedicalClaim corporateMedicalClaim, @PathVariable Integer corporateId){

        return corporateMedicalClaimService.saveCorporateMedicalClaim(corporateMedicalClaim, corporateId);
    }
}
