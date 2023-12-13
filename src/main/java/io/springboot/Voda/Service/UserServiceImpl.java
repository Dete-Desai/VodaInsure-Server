package io.springboot.Voda.Service;

import io.springboot.Voda.Entity.User;
import io.springboot.Voda.Repository.UserRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;
   
    @Override
    public User registerUser(User user) {
    	
    	        return userRepository.save(user);

    }

    @Override
    public User loginUserByEmailAndPassword(String email, String password) {
        // Implement login logic by email and password
        // This method should validate credentials and return the user if valid
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User loginUserByPhoneNumberAndPassword(String phonenumber, String password) {
        // Implement login logic by phone number and password
        // This method should validate credentials and return the user if valid
        return userRepository.findByPhonenumberAndPassword(phonenumber, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByPhonenumber(String phonenumber) {
        return userRepository.findByPhonenumber(phonenumber);
    }

    // Add any other methods as needed

}
