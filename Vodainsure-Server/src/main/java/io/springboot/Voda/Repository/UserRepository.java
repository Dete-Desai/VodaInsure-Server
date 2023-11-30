package io.springboot.Voda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springboot.Voda.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
