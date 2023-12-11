package io.springboot.vodainsure.controller;

// import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
// import io.springboot.vodainsure.config.MyUserDetails;
// import io.springboot.vodainsure.dto.AuthRequest;
import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.repository.UserRepository;
import io.springboot.vodainsure.service.JwtService;
// import io.springboot.vodainsure.service.JwtService;
// import io.springboot.vodainsure.service.JwtService;
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
    // 0795502980
    @PostMapping("/user/save")
    public ResponseEntity<Object> saveUSer(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        if (result.getNationalId() > 0){
            return ResponseEntity.ok("USer Was Saved");
        }
        return ResponseEntity.status(404).body("Error, USer Not Saved");
    }

// @PostMapping("/register")
// public User registUser(@RequestBody User user){

//         return userService.registUser(user);
//     }
    @PostMapping("/register1")
    public String addNewUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

     
 @PostMapping("/authenticate2")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
            // return "succe";
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
        }

    // @PostMapping("/authenticate")
    // public ResponseEntity<Object> authenticateUser(@RequestBody User user, HttpSession session) {
    //     return userService.authenticateUser1(user, session);
    // }
      @GetMapping("/getuser")
      public UserDTO getuser(){
    // public UserDTO getuser(HttpSession session){
        // return userService.getUser(session);
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
   @GetMapping("/hi")
    public String hi(){
        return "hiiiiiii";
    }
   
    @GetMapping("/hello")
    public String hello(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "Hello, " + user.getEmail() + "!";
        } else {
            return "Unauthorized access!";
        }
    }
}
  

