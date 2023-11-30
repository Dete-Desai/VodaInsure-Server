package io.springboot.vodainsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot.vodainsure.entity.MotorCover;

@Repository
public interface MotorCoverRepository extends JpaRepository<MotorCover, Integer > {
    boolean existsBymotorId(Integer motorId);
}

