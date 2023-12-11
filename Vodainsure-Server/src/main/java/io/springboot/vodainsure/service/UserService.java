package io.springboot.vodainsure.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import io.springboot.vodainsure.dto.UserDTO;
// import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.User;
// import org.mindrot.jbcrypt.BCrypt;
// import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;

import io.springboot.vodainsure.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import io.springboot.vodainsure.service.ModelMapperConfig;

@Service
public class UserService {

    @Autowired
private UserRepository userRepository;




//   public MyUserDetails currentUser() {
//         SecurityContext context = SecurityContextHolder.getContext();
//         return (MyUserDetails) context.getAuthentication().getPrincipal();
//     }
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return "user added to system ";
    }


// public User registUser(User user){
//     String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//     user.setPassword(hashedPassword);
//     return userRepository.save(user);
// }

// public String authenticateUser(User user, HttpSession session) {
//     User storedUser = userRepository.findByEmail(user.getEmail());
//     if (storedUser != null && BCrypt.checkpw(user.getPassword(), storedUser.getPassword())) {
//         session.setAttribute("user", storedUser);
//         return "Authentication successful!";
//     } else {
//         return "Authentication failed!";
//     }
// }
//    public ResponseEntity<Object> authenticateUser1(User user, HttpSession session) {
//        User storedUser = userRepository.findByEmail(user.getEmail());

//        if (storedUser != null && BCrypt.checkpw(user.getPassword(), storedUser.getPassword())) {
//            session.setAttribute("user", storedUser);
//            return ResponseEntity.ok().body(Map.of("status", "success", "message", "Authentication successful"));
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("status", "error", "message", "Authentication failed"));
//        }
//    }



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

