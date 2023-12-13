package io.springboot.Voda.Service;

import java.util.List;

import io.springboot.Voda.Entity.User;



		public interface UserServiceInterface {

		    User registerUser(User user);

		    User loginUserByEmailAndPassword(String email, String password);

		    User loginUserByPhoneNumberAndPassword(String phonenumber, String password);

		    List<User> getAllUsers();

		    User getUserById(Integer id);

		    User getUserByEmail(String email);

		    User getUserByPhonenumber(String phonenumber);

		    // Add any other methods as needed

		}

	




