package io.springboot.Voda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;

}
