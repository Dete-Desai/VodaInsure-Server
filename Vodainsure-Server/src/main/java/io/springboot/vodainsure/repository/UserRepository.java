package io.springboot.vodainsure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.springboot.vodainsure.entity.User;




@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
//    @Query(value = "select * from user where full_name = ?1", nativeQuery = true)
    Optional<User> findByEmail(String username);
    // User findByEmail(String email);
    User findBynationalId(Integer nationalId);
    //  Optional <User> findBynationalId(Integer nationalId);
   
}
