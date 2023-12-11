package io.springboot.vodainsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot.vodainsure.entity.MotorClaim;

@Repository
public interface MotorClaimRepository extends JpaRepository<MotorClaim, Integer >{
    boolean existsBymotorClaimId(Integer motorClaimId);
    MotorClaim findByMotorClaimId(Integer motorClaimId);
}