package io.springboot.vodainsure.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import io.springboot.vodainsure.entity.User;

import io.springboot.vodainsure.repository.UserRepository;


@Service
public class UserService {

private final UserRepository userRepository;



 public UserService(UserRepository userRepository) {
     this.userRepository = userRepository;
    
 }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return "user added to system ";
    }
   

   
}

