package io.springboot.Voda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springboot.Voda.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	User findByEmail(String Email);
	User findByPhonenumber(String Phonenumber);
	User findByEmailAndPassword(String Email,String password);
	User findByPhonenumberAndPassword(String Phonenumber,String password);
	
	
	
	
	
	}
	

