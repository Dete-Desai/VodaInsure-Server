package io.springboot.Voda.Service;

import java.util.List;


import io.springboot.Voda.Entity.SelfmedicalClaims;


public interface SelfmedicalClaimsServiceInterface {
	 
	SelfmedicalClaims saveSelfmedicalClaims(SelfmedicalClaims selfmedicalClaims);
	SelfmedicalClaims getselfmedicalClaimsById(Integer selfmedicalClaimId);
	List<SelfmedicalClaims> getAllSelfmedicalClaims();
}
