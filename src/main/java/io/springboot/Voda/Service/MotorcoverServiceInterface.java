package io.springboot.Voda.Service;

import java.util.List;

import io.springboot.Voda.Entity.Motor_cover;


public interface MotorcoverServiceInterface {
	Motor_cover saveSelfmedicalCover(Motor_cover Motor_cover);
	Motor_cover getMotor_coverById(Integer MotorID);
	
	
	List<Motor_cover> getAllMotor_Covers();

}
