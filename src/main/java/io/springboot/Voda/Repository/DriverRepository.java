package io.springboot.Voda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springboot.Voda.Entity.Driver;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

	static Driver saveDriver(Driver driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
