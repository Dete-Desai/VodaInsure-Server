package io.springboot.Voda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
  private UserServiceImpl userService;

 @PostMapping("/register")
  public User registerUser(@RequestBody User user) {
  return userService.registerUser(user);
    }

  @PostMapping("/login")
   public User loginUser(@RequestParam String email, @RequestParam String Password) {
   return userService.loginUser(email, Password);
    }

  @PostMapping("/loginByPhoneNumber")
  public User loginUserByPhone(@RequestParam String phonenumber, @RequestParam String Password) {
      return userService.loginUserbyphone(phonenumber, Password);
}
}
