package io.springboot.vodainsure.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContext;
// import org.springframework.security.core.context.SecurityContextHolder;
// // import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
import io.springboot.vodainsure.exception.UserNotFoundException;
import io.springboot.vodainsure.config.CustomUserDetails;
import io.springboot.vodainsure.dto.AuthRequest;
import io.springboot.vodainsure.dto.UserDTO;
// import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.User;
// import org.mindrot.jbcrypt.BCrypt;
// import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import io.springboot.vodainsure.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import io.springboot.vodainsure.service.ModelMapperConfig;

@Service
public class UserService {

    @Autowired
private UserRepository userRepository;

@Autowired
private AuthenticationManager authenticationManager;
@Autowired
private JwtService jwtService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return "user added to system ";
    }

  public String authenticateAndGetToken(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }



@Autowired
private ModelMapper modelMapper;

public UserDTO convertToUserDTO(User user) {
return modelMapper.map(user, UserDTO.class);
}

public UserDTO getUser() {
     CustomUserDetails currentUser = CustomUserDetails.getCurrentUser();
        User user = currentUser.getUser();    
    return  convertToUserDTO(user) ;
}

public User updateUser(HttpSession session, User updatedUserDetails) {

User authenticatedUser = (User) session.getAttribute("user");
    int nationalId = authenticatedUser.getNationalId();
    if (userRepository.existsById(nationalId)) {
      
        User existingUser = userRepository.findById(nationalId).get();

        
        existingUser.setFullName(updatedUserDetails.getFullName());
        existingUser.setEmail(updatedUserDetails.getEmail());
        existingUser.setPhoneNumber(updatedUserDetails.getPhoneNumber());
       
        userRepository.save(existingUser);
        return existingUser;

    } else {
        
        return null;
    }
}

    public UserDTO returnUser ( HttpSession session){
User authenticatedUser = (User) session.getAttribute("user");

if (authenticatedUser != null) {
    
   return  convertToUserDTO(authenticatedUser) ;
} else {
   
    return null;
}
}  

}

