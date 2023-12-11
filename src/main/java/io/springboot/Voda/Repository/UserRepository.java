package io.springboot.Voda.Repository;

import io.springboot.Voda.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByPhonenumber(String phonenumber);
	User findByEmailAndPassword(String email, String password);
	User findByPhonenumberAndPassword(String phonenumber, String password);
}
