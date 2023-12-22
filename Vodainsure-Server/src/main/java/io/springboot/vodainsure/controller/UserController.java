package io.springboot.vodainsure.controller;

// import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.vodainsure.config.CustomUserDetails;
import io.springboot.vodainsure.dto.AuthRequest;
import io.springboot.vodainsure.dto.UserDTO;
import io.springboot.vodainsure.entity.AuthResponse;

import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.repository.UserRepository;
import io.springboot.vodainsure.service.JwtService;

import io.springboot.vodainsure.service.UserService;
import jakarta.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")

public class UserController {
       @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String goH0me(){
        return "Thisn is publickly accesible withing needing authentication ";
    }
    
    @PostMapping("/register")
    public ResponseEntity<Object> saveUSer(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        if (result.getNationalId() > 0){
            return ResponseEntity.ok("USer Was Saved");
        }
        return ResponseEntity.status(404).body("Error, USer Not Saved");
    }


    
 @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            String token = userService.authenticateAndGetToken(authRequest);
            AuthResponse response = new AuthResponse(HttpStatus.OK.value(), "Authentication successful", token);
            System.out.println("success");
            return ResponseEntity.ok(response);
        } catch (UsernameNotFoundException e) {
            AuthResponse response = new AuthResponse(HttpStatus.UNAUTHORIZED.value(), "Invalid credentials", null);
            System.out.println("fail");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
     

      @GetMapping("/getuser")
      public UserDTO getuser(){
    
        return userService.getUser();
    }
@GetMapping("/customuser")
public User getMethodName() {
    CustomUserDetails currentUser = CustomUserDetails.getCurrentUser();
        User user = currentUser.getUser();
    return user;
}

    @RequestMapping(method = RequestMethod.PUT, value="/updateuser")
    public void updateUser(HttpSession session, @RequestBody User user) {

        userService.updateUser(session, user);
    }
  
   
  
}
  

