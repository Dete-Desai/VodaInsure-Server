package io.springboot.Voda.Service;

import java.util.List;

import io.springboot.Voda.Entity.CorporateMedicalClaims;



public interface CorporateMedicalClaimsInterface {
	CorporateMedicalClaims saveCorporateMedicalClaims(CorporateMedicalClaims corporateMedicalClaims);
	CorporateMedicalClaims getCorporateMedicalClaimsById(Integer CorporatemedicalClaimId);
	List<CorporateMedicalClaims> getAllCorporateMedicalClaims();
}
