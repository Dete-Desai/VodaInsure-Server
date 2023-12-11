package io.springboot.Voda.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import io.springboot.Voda.Entity.Motor_cover;

public interface MotorcoverRepository extends JpaRepository<Motor_cover,Integer>{

	Optional<Motor_cover> findById(Integer motorID);

}
