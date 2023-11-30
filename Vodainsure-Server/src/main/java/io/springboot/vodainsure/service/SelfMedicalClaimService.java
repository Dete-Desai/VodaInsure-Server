package io.springboot.vodainsure.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.config.MyUserDetails;

import io.springboot.vodainsure.entity.SelfMedicalClaim;
import io.springboot.vodainsure.entity.SelfMedicalCover;
import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.repository.SelfMedicalClaimRepository;


@Service
public class SelfMedicalClaimService {
   @Autowired
   private  SelfMedicalClaimRepository selfMedicalClaimRepository;

   
    public SelfMedicalClaim saveSelfMedicalClaim (SelfMedicalClaim selfMedicalClaim, Integer selfId){
       MyUserDetails currentUser = MyUserDetails.getCurrentUser();
        User user = currentUser.getUser();

        Optional<SelfMedicalCover> optionalSelfMedicalCover = user.getSelfMedicalCovers().stream()
                .filter(selfMedicalCover -> selfMedicalCover.getSelfId() == (selfId))
                .findFirst();
                if (optionalSelfMedicalCover.isPresent()){

                    SelfMedicalCover foundSelfMedicalCover = optionalSelfMedicalCover.get();

                    int randomValue;
                    do{
                        randomValue = 100_000 + new Random().nextInt(900_000);
                        }while(selfMedicalClaimRepository.existsByselfClaimId(randomValue));

                        
                        
                          selfMedicalClaim.setSelfClaimId(user.getNationalId());
                        selfMedicalClaim.setPolicyNumber(foundSelfMedicalCover.getPolicyNumber());
                }
                      
        return  selfMedicalClaimRepository.save(selfMedicalClaim);
}

}
