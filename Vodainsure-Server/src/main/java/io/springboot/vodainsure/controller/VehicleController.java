package io.springboot.vodainsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.service.VehicleService;

@RestController
public class VehicleController {
    @Autowired 
    private VehicleService vehicleService;

    @PostMapping("/addvehicle")
    @PreAuthorize("hasAuthority('ROLE_USER')")
     public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle( vehicle);
    }
}
