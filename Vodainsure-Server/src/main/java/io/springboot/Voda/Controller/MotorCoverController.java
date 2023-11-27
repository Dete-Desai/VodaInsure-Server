package io.springboot.Voda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.Voda.Entity.Motor_cover;
import io.springboot.Voda.Service.Motor_coverService;

@RestController
@RequestMapping("/api")

public class MotorCoverController {
	@Autowired
	private Motor_coverService motor_coverService;

	@PostMapping("/motor-covers")
	  public ResponseEntity<Motor_cover> createMotorCover(@RequestBody Motor_cover request) {
	        Motor_cover motorCover = motor_coverService.saveMotorCover(request);
	        return ResponseEntity.ok(motorCover);

}
}