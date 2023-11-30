package io.springboot.Voda.Controller;

import io.springboot.Voda.Entity.Driver;
import io.springboot.Voda.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{driverId}")
    public Driver getDriverById(@PathVariable Integer driverId) {
        return driverService.getDriverById(driverId);
    }

    @PostMapping
    public Driver saveDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    @PostMapping("/associate-with-motor/{vinId}")
    public void associateDriverWithMotor(@PathVariable Integer vinId, @RequestBody Driver driver) {
        driverService.associateDriverWithMotor(vinId, driver);
    }

    @DeleteMapping("/{driverId}")
    public void deleteDriver(@PathVariable Integer driverId) {
        driverService.deleteDriver(driverId);
    }
}
