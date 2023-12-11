package io.springboot.Voda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import io.springboot.Voda.Entity.User;
import io.springboot.Voda.Repository.UserRepository;

@Service
@Transactional
public class UserService {
	 @Autowired
	   
	private final  UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	public List<User>getAllUsers(){
		return userRepository.findAll();
	}
	 public User getUserById(Integer id) {
	  return userRepository.findById(id).orElse(null);
	    }

   public User getUserByEmail(String email) {
	 return userRepository.findByEmail(email);
		
		
	}
   public User getUserByPhonenumber(String phonenumber) {
	   return userRepository.findByPhonenumber(phonenumber);
   }
   public User loginUserByEmailAndPassword(String Email, String Password) {
       return userRepository.findByEmailAndPassword(Email, Password);
   }

 public User LoginUserByPhonenumberAndPassword(String Phonenumber,String password) {
	 return userRepository.findByPhonenumberAndPassword(Phonenumber,password);
 }
}
