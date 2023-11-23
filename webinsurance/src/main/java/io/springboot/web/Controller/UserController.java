package io.springboot.web.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import io.springboot.web.Entity.User;
import io.springboot.web.Repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	public String GetAllUser(Model model) {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return "users";
	}
	
	
}

