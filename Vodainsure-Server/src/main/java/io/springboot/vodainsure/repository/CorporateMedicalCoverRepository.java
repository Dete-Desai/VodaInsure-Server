package io.springboot.vodainsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springboot.vodainsure.entity.CorporateMedicalCover;


public interface CorporateMedicalCoverRepository extends JpaRepository<CorporateMedicalCover, Integer>{
    boolean existsBycorporateId(Integer corporateId);
    
}
