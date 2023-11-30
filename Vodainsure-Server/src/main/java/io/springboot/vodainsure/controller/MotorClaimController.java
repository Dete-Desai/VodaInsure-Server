package io.springboot.vodainsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.vodainsure.entity.MotorClaim;
import io.springboot.vodainsure.service.MotorClaimService;

@RestController
public class MotorClaimController {
    

    @Autowired
    private MotorClaimService motorClaimService;

    @PostMapping("/{motorId}/updatemotorclaim")
    public MotorClaim makeMotorClaim (@RequestBody MotorClaim motorClaim, @PathVariable Integer motorId){

        return motorClaimService.saveMotorClaim(motorClaim, motorId);

        // return null;
    }
}
