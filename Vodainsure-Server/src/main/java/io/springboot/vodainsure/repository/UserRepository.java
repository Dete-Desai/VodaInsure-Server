package io.springboot.vodainsure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.springboot.vodainsure.entity.User;




@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByEmail(String username);
    // User findByEmail(String email);
    User findBynationalId(Integer nationalId);
    //  Optional <User> findBynationalId(Integer nationalId);
   
}
