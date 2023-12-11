package io.springboot.Voda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.Voda.Entity.Motor_cover;

import io.springboot.Voda.Service.MotorCoverServiceImpli;


@RestController
@RequestMapping("api/motorcovers")

public class MotorCoverController {
@Autowired
private MotorCoverServiceImpli MotorCoverService;

 @PostMapping("/save")
 public Motor_cover saveMotor_cover(@RequestBody Motor_cover motor_cover) {
 return MotorCoverService.saveMotor_cover(motor_cover);

}
 @GetMapping("/get/{MotorID;}")
 public Motor_cover getMotor_coverById(@PathVariable Integer MotorID) {
 return MotorCoverService.getMotor_coverById(MotorID);
}
 @GetMapping("/all")
 public List<Motor_cover> getAllmotorCovers() {
 return MotorCoverService.getAllMotorcovers();
}
	 
}
