package io.springboot.vodainsure.repository;

import io.springboot.vodainsure.entity.SelfMedicalCover;
import org.springframework.data.jpa.repository.JpaRepository;

import io.springboot.vodainsure.entity.CorporateMedicalCover;


public interface CorporateMedicalCoverRepository extends JpaRepository<CorporateMedicalCover, Integer>{
    boolean existsBycorporateId(Integer corporateId);
    CorporateMedicalCover findByCorporateId(Integer corporateId);
}
