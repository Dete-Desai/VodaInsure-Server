package io.springboot.Voda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.CorporateMedicalClaims;

import io.springboot.Voda.Repository.CorporateMedicalClaimsRepository;

@Service

public class CorporateMedicalClaimsServiceimpli {
	@Autowired
	CorporateMedicalClaimsRepository corporateMedicalClaimsRepository;
public CorporateMedicalClaims saveCorporateMedicalClaims(CorporateMedicalClaims corporateMedicalClaims) {
	return corporateMedicalClaimsRepository.save(corporateMedicalClaims);
}
public CorporateMedicalClaims getCorporateMedicalClaimsById(Integer CorporatemedicalClaimId ) {
    return corporateMedicalClaimsRepository.findById(CorporatemedicalClaimId).orElse(null);
}
public List<CorporateMedicalClaims> getAllCorporateClaims() {
return corporateMedicalClaimsRepository.findAll();
}
}
