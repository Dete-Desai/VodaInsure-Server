package io.springboot.Voda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.MotorClaims;
import io.springboot.Voda.Repository.MotorClaimsRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class MotorClaimsServiceImpli {
	@Autowired
MotorClaimsRepository motorClaimsRepository;
	public MotorClaims saveMotorClaims(MotorClaims motorClaims) {
		return motorClaimsRepository.save(motorClaims);
	}
	public MotorClaims getMotorClaimsById(Integer ClaimId) {
		return motorClaimsRepository.findById(ClaimId).orElse(null);
	}
	public List<MotorClaims>getAllMotorClaims(){
		return motorClaimsRepository.findAll();
	}
}
