package io.springboot.vodainsure.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.CorporateMedicalClaim;
import io.springboot.vodainsure.entity.CorporateMedicalCover;

import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.repository.CorporateMedicalClaimRepository;


@Service
public class CorporateMedicalClaimService  {

    @Autowired
    private  CorporateMedicalClaimRepository corporateMedicalClaimRepository;
    
    public CorporateMedicalClaim saveCorporateMedicalClaim (CorporateMedicalClaim corporateMedicalClaim, Integer corporateId){
       MyUserDetails currentUser = MyUserDetails.getCurrentUser();
        User user = currentUser.getUser();

        Optional<CorporateMedicalCover> optionalCorporateMedicalCover = user.getCorporateMedicalCovers().stream()
                .filter(corporateMedicalCover -> corporateMedicalCover.getCorporateId() == (corporateId))
                .findFirst();
                if (optionalCorporateMedicalCover.isPresent()){

                    CorporateMedicalCover foundCorporateMedicalCover = optionalCorporateMedicalCover.get();

                    int randomValue;
                    do{
                        randomValue = 100_000 + new Random().nextInt(900_000);
                        }while(corporateMedicalClaimRepository.existsBycorporateClaimId(randomValue));

                        
                        
                          corporateMedicalClaim.setCorporateClaimId(user.getNationalId());
                        corporateMedicalClaim.setPolicyNumber(foundCorporateMedicalCover.getPolicyNumber());
                }
                      
        return  corporateMedicalClaimRepository.save(corporateMedicalClaim);
}

}
