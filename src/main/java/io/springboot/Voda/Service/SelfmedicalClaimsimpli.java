package io.springboot.Voda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.SelfmedicalClaims;

import io.springboot.Voda.Repository.SelfmedicalclaimsRepository;


@Service

public class SelfmedicalClaimsimpli {
	@Autowired
	private SelfmedicalclaimsRepository selfmedicalclaimsRepository;
	
	 public SelfmedicalClaims saveSelfmedicalCover(SelfmedicalClaims selfmedicalClaims) {
	 return selfmedicalclaimsRepository.save(selfmedicalClaims);
	    }
    public SelfmedicalClaims getSelfmedicalClaimsById(Integer selfmedicalClaimId) {
	        return selfmedicalclaimsRepository.findById(selfmedicalClaimId).orElse(null);
	    }
    public List<SelfmedicalClaims> getAllClaims() {
        return selfmedicalclaimsRepository.findAll();
}
	public SelfmedicalClaims saveSelfmedicalClaims(SelfmedicalClaims selfmedicalClaims) {
		// TODO Auto-generated method stub
		return null;
	}

}

