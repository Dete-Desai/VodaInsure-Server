package io.springboot.vodainsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.vodainsure.entity.MotorCover;
import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.service.MotorCoverService;
@RestController
public class MotorCoverController {
    @Autowired
    private MotorCoverService motorCoverService;

    //    @PostMapping()
    //    @PreAuthorize("hasAuthority('ROLE_USER')")
    // public ResponseEntity<String> updateMotorCover(@PathVariable Integer vehicleId) {
    //     try {
    //         motorCoverService.updateMotorCoverForVehicle(vehicleId);
    //         return ResponseEntity.ok("MotorCover updated successfully");
    //     } catch (Exception e) {
    //         // Handle exceptions appropriately (e.g., log and return an error response)
    //         return"/{vehicleId}/updatemotorcover" ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating MotorCover");
    //     }
    // }

    @PostMapping("/updatemotorcover")
    @PreAuthorize("hasAuthority('ROLE_USER')")
     public MotorCover updateMotorCover(@RequestBody MotorCover motorCover , @RequestBody Vehicle vehicle  ) {
        // @PathVariable Integer vehicleId    @RequestBody MotorCover motorCover 
        return motorCoverService.updateMotorCoverForVehicle(motorCover, vehicle);
        // {vehicleId}/
        // vehicleId
    }
}
