package io.springboot.Voda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.springboot.Voda.Entity.Motor;
import io.springboot.Voda.Service.MotorService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/motors")
public class MotorController {

    @Autowired
    private MotorService motorService;

    @GetMapping
    public ResponseEntity<List<Motor>> getAllMotors() {
        List<Motor> motors = motorService.getAllMotors();
        return new ResponseEntity<>(motors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motor> getMotorById(@PathVariable Integer id) {
        Optional<Motor> motor = motorService.getMotorById(id);
        return motor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Motor> saveMotor(@RequestBody Motor motor) {
        Motor savedMotor = motorService.saveMotor(motor);
        return new ResponseEntity<>(savedMotor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotor(@PathVariable Integer id) {
        motorService.deleteMotor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
