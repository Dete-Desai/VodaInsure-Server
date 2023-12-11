package io.springboot.vodainsure.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import io.springboot.vodainsure.config.CustomUserDetails;
import io.springboot.vodainsure.entity.*;
import io.springboot.vodainsure.repository.SelfMedicalCoverRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import io.springboot.vodainsure.config.MyUserDetails;

import io.springboot.vodainsure.repository.SelfMedicalClaimRepository;


@Service
public class SelfMedicalClaimService {
   @Autowired
   private  SelfMedicalClaimRepository selfMedicalClaimRepository;

    @Autowired
    private SelfMedicalCoverRepository selfMedicalCoverRepository;

   
    public SelfMedicalClaim saveSelfMedicalClaim ( SelfMedicalClaim selfMedicalClaim, Integer selfId){
       CustomUserDetails foundUser = CustomUserDetails.getCurrentUser();
        User currentUser = foundUser.getUser();      
        
         Optional<SelfMedicalCover> optionalSelfMedicalCover = currentUser.getSelfMedicalCovers().stream()
                 .filter(selfMedicalCover -> selfMedicalCover.getSelfId() == (selfId))
                 .findFirst();
                 if (optionalSelfMedicalCover.isPresent()){

                     SelfMedicalCover foundSelfMedicalCover = optionalSelfMedicalCover.get();

                     int randomValue;
                     do{
                         randomValue = 100_000 + new Random().nextInt(900_000);
                         }while(selfMedicalClaimRepository.existsByselfClaimId(randomValue));

                    selfMedicalClaim.setSelfMedicalCover(foundSelfMedicalCover);
                     selfMedicalClaim.setSelfClaimId(randomValue);
                     selfMedicalClaim.setNationalId(currentUser.getNationalId());
                     selfMedicalClaim.setPolicyNumber(foundSelfMedicalCover.getPolicyNumber());

                 }
                      
        return  selfMedicalClaimRepository.save(selfMedicalClaim);
}

    public SelfMedicalClaim getSelfMedicalClaim(Integer selfClaimId) {
        SelfMedicalClaim selfMedicalClaim = selfMedicalClaimRepository.findBySelfClaimId(selfClaimId);
        if (selfMedicalClaim != null){
            return selfMedicalClaim;
        }
        else {
            return null;
        }
    }
    public List<SelfMedicalClaim> getSelfMedicalClaims(Integer selfId){
        SelfMedicalCover selfMedicalCover = selfMedicalCoverRepository.findBySelfId(selfId);
        if (selfMedicalCover != null){
            List<SelfMedicalClaim> userSelfMedicalClaims = selfMedicalCover.getSelfMedicalClaims();
            return  userSelfMedicalClaims;
        }else {
            return null;
        }

    }
}
