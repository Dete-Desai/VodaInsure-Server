package io.springboot.vodainsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot.vodainsure.entity.SelfMedicalCover;

@Repository
public interface SelfMedicalCoverRepository extends JpaRepository<SelfMedicalCover, Integer> {
    boolean existsByselfId(Integer selfId);
}
