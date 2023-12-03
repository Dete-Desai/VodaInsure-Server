package io.springboot.Voda.Service;

import io.springboot.Voda.Entity.User;

public interface UserServiceInterface  {
	 User registerUser(User user);
	    User loginUser(String email, String password);
	    User loginUserbyphone(String phonenumber,String password);
	}


