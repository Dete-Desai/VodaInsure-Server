package io.springboot.vodainsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot.vodainsure.entity.SelfMedicalClaim;
@Repository
public interface SelfMedicalClaimRepository extends JpaRepository <SelfMedicalClaim, Integer> {   

    boolean existsByselfClaimId(Integer selfClaimId);
}
