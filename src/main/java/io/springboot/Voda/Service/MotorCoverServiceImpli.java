package io.springboot.Voda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.Motor_cover;
import io.springboot.Voda.Repository.MotorcoverRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class MotorCoverServiceImpli {
	
	@Autowired
	private MotorcoverRepository motorcoverRepository;
	
	public Motor_cover saveMotor_cover(Motor_cover motor_cover) {
		return motorcoverRepository.save(motor_cover);
		
	}
public Motor_cover getMotor_coverById(Integer MotorID){
	return motorcoverRepository.findById(MotorID).orElse(null);
}

public List<Motor_cover>getAllMotorcovers(){
return (List<Motor_cover>) motorcoverRepository.findAll();
}
}
