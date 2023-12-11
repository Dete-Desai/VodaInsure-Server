package io.springboot.Voda.Repository;

import io.springboot.Voda.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByPhonenumber(String phonenumber);
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.Password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    
    @Query("SELECT u FROM User u WHERE u.phonenumber = :phonenumber AND u.Password = :password")
    User findByPhonenumberAndPassword(@Param("phonenumber") String phonenumber, @Param("password") String password);
}
