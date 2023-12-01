package io.springboot.Voda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.Motor_cover;
import io.springboot.Voda.Repository.MotorcoverRepository;

@Service

public class Motor_coverService {
	
	@Autowired
	private MotorcoverRepository motorRepository;
	

    public Motor_cover saveMotorCover(Motor_cover request) {
        Motor_cover motorCover = new Motor_cover();
        motorCover.setMotorID(generateSixDigitRandomNumber());
        motorCover.setMotor_category(request.getMotor_category());
        motorCover.setRegistration_number(request.getRegistration_number());
        motorCover.setChasis_Number(request.getChasis_Number());
        motorCover.setCv_number(request.getCv_number());
        motorCover.setTonnage(request.getTonnage());
        motorCover.setVehicle_value(request.getVehicle_value());
        motorCover.setManufacture_year(request.getManufacture_year());
        motorCover.setExperience(request.getExperience());
        motorCover.setNationalId(request.getNationalId());
        motorCover.setPolicy_number(request.getPolicy_number());
        motorCover.setCover_type(request.getCover_type());
        motorCover.setRenewaldate(request.getRenewaldate());
        motorCover.setExpirydate(request.getExpirydate());
        

        return motorRepository.save(motorCover);
        
        

}
    private Long generateSixDigitRandomNumber() {
        // Generate a random six-digit number
        return Long.parseLong(String.format("%06d", (int) (Math.random() * 1000000)));
    }

    }

