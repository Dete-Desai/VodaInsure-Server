package io.springboot.Voda.Service;

import io.springboot.Voda.Entity.Driver;
import io.springboot.Voda.Entity.Motor;
import io.springboot.Voda.Repository.DriverRepository;
import io.springboot.Voda.Repository.MotorRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private MotorRepository motorRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(Integer driverId) {
        return driverRepository.findById(driverId).orElse(null);
    }

    public Driver saveDriver(Driver driver) {
        Motor motor = driver.getMotor();

        if (motor != null) {
            motor.getDrivers().add(driver);
            motorRepository.save(motor);
            System.out.println("Generated VinId: " + motor.getVinId());
        }

        return driverRepository.save(driver);
    }

    public void associateDriverWithMotor(Integer vinId, Driver driver) {
        Motor existingMotor = motorRepository.findById(vinId).orElse(null);

        if (existingMotor != null) {
            driver.setMotor(existingMotor);
            saveDriver(driver);
        } else {
            // Handle the case where the Motor entity with the provided VinId does not exist
            // You can throw an exception, log an error, or handle it based on your application logic
        }
    }

    public void deleteDriver(Integer driverId) {
        driverRepository.deleteById(driverId);
    }
}
