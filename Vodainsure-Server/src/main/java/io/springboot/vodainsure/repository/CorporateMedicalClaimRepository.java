package io.springboot.vodainsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot.vodainsure.entity.CorporateMedicalClaim;

@Repository
public interface  CorporateMedicalClaimRepository extends JpaRepository <CorporateMedicalClaim, Integer> {
    boolean existsBycorporateClaimId(Integer corporateClaimId);
    CorporateMedicalClaim findByCorporateClaimId(Integer corporateClaimId);
}
