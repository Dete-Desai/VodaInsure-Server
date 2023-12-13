package io.springboot.Voda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.Voda.Entity.User;
import io.springboot.Voda.Service.UserServiceImpl;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
  private UserServiceImpl userServiceInterface;

 @PostMapping("/register")
 public ResponseEntity<User> registerUser(@RequestBody User user) {
     User registeredUser = userServiceInterface.registerUser(user);
     if (registeredUser != null) {
         return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
     } else {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
 }

  @PostMapping("/login")
  public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
      User user = userServiceInterface.loginUserByEmailAndPassword(email, password);
      if (user != null) {
          return new ResponseEntity<>(user, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }
  }

  @PostMapping("/loginByPhoneNumber")
  public ResponseEntity<User> loginUserByphone(@RequestParam String phonenumber, @RequestParam String password) {
      User user = userServiceInterface.loginUserByEmailAndPassword(phonenumber, password);
      if (user != null) {
          return new ResponseEntity<>(user, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }
  }
  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllUsers() {
      List<User> users = userServiceInterface.getAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
      
  }
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Integer id) {
  User user = userServiceInterface.getUserById(id);
   if (user != null) {
   return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
}
  @GetMapping("/email/{email}")
  public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
  User user = userServiceInterface.getUserByEmail(email);
   if (user != null) {
  return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/phonenumber/{phonenumber}")
  public ResponseEntity<User> getUserByPhonenumber(@PathVariable String phonenumber) {
      User user = userServiceInterface.getUserByPhonenumber(phonenumber);
      if (user != null) {
          return new ResponseEntity<>(user, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      
}}