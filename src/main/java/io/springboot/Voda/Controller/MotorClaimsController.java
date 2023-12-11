package io.springboot.Voda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.springboot.Voda.Entity.MotorClaims;

import io.springboot.Voda.Service.MotorClaimsServiceImpli;

@Service
@RequestMapping("api/motorclaims")

public class MotorClaimsController {
	@Autowired
	private MotorClaimsServiceImpli motorClaimsService;
	
 @PostMapping("/save")
 public MotorClaims saveMotorClaims(@RequestBody MotorClaims MotorClaims) {
 return motorClaimsService.saveMotorClaims(MotorClaims);
	 	 
	  }
	
@GetMapping("/get/{ClaimId}")
public MotorClaims getMotorClaimsById(@PathVariable Integer ClaimId) {
return motorClaimsService.getMotorClaimsById(ClaimId);

}
@GetMapping
public List<MotorClaims> getAllMotorClaims() {
return motorClaimsService.getAllMotorClaims();
}
}
