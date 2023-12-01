package io.springboot.Voda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.Motor;
import io.springboot.Voda.Repository.MotorRepository;

@Service
public class MotorService {


    @Autowired
    private MotorRepository motorRepository;

    public List<Motor> getAllMotors() {
        return motorRepository.findAll();
    }

    public Optional<Motor> getMotorById(Integer id) {
        return motorRepository.findById(id);
    }

    public Motor saveMotor(Motor motor) {
        return motorRepository.save(motor);
    }

    public void deleteMotor(Integer id) {
        motorRepository.deleteById(id);
    }
}
