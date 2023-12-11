package io.springboot.Voda.Service;


import java.util.List;

import io.springboot.Voda.Entity.MotorClaims;


public interface MotorClaimsServiceInterface {
	
MotorClaims saveMotorClaims(MotorClaims MotorClaims);
	MotorClaims getMotorClaimsById(Integer ClaimId);
	List<MotorClaims> getAllMotorClaims();
	

}
