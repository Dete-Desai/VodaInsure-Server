package io.springboot.Voda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.springboot.Voda.Entity.User;
import io.springboot.Voda.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {

   @Autowired
  private UserRepository userRepository;

 @Override
 public User registerUser(User user) {
 if (userRepository.findByEmail(user.getEmail()) != null
 || userRepository.findByPhonenumber(user.getPhonenumber()) != null) {
  return null;
     }
  return userRepository.save(user);
    }

  @Override
  public User loginUser(String email, String password) {
  User user = userRepository.findByEmail(email);

  if (user != null && user.getPassword().equals(password)) {
  return user;
    }
   return null;
    }

  @Override
  public User loginUserbyphone(String phonenumber, String password) {
   User user = userRepository.findByPhonenumber(phonenumber);

   if (user != null && user.getPassword().equals(password)) {
     return user;
        }
        return null;
    }
}
