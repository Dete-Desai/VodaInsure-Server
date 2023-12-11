 package io.springboot.vodainsure.service;

 import java.util.List;
 import java.util.Optional;
 import java.util.Random;

 import io.springboot.vodainsure.entity.*;
 import io.springboot.vodainsure.repository.CorporateMedicalCoverRepository;
 import jakarta.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 // import io.springboot.vodainsure.config.MyUserDetails;

 import io.springboot.vodainsure.repository.CorporateMedicalClaimRepository;


 @Service
 public class CorporateMedicalClaimService  {

     @Autowired
     private  CorporateMedicalClaimRepository corporateMedicalClaimRepository;

     @Autowired
     private CorporateMedicalCoverRepository corporateMedicalCoverRepository;

     public CorporateMedicalClaim saveCorporateMedicalClaim (HttpSession session, CorporateMedicalClaim corporateMedicalClaim, Integer corporateId){
         User currentUser = (User) session.getAttribute("user");
         Optional<CorporateMedicalCover> optionalCorporateMedicalCover = currentUser.getCorporateMedicalCovers().stream()
                 .filter(corporateMedicalCover -> corporateMedicalCover.getCorporateId() == (corporateId))
                 .findFirst();
         if (optionalCorporateMedicalCover.isPresent()){

             CorporateMedicalCover foundCorporateMedicalCover = optionalCorporateMedicalCover.get();

             int randomValue;
             do{
                 randomValue = 100_000 + new Random().nextInt(900_000);
             }while(corporateMedicalClaimRepository.existsBycorporateClaimId(randomValue));

             corporateMedicalClaim.setCorporateMedicalCover(foundCorporateMedicalCover);
             corporateMedicalClaim.setCorporateClaimId(randomValue);
             corporateMedicalClaim.setNationalId(currentUser.getNationalId());
             corporateMedicalClaim.setPolicyNumber(foundCorporateMedicalCover.getPolicyNumber());

         }

         return  corporateMedicalClaimRepository.save(corporateMedicalClaim);
     }

     public CorporateMedicalClaim getCorporateMedicalClaim(Integer corporateClaimId) {
         CorporateMedicalClaim corporateMedicalClaim = corporateMedicalClaimRepository.findByCorporateClaimId(corporateClaimId);
         if (corporateMedicalClaim != null){
             return corporateMedicalClaim;
         }
         else {
             return null;
         }
     }
     public List<CorporateMedicalClaim> getCorporateMedicalClaims(Integer corporateId){
         CorporateMedicalCover corporateMedicalCover = corporateMedicalCoverRepository.findByCorporateId(corporateId);
         if (corporateMedicalCover != null){
             List<CorporateMedicalClaim> userCorporateMedicalClaims = corporateMedicalCover.getCorporateMedicalClaims();
             return  userCorporateMedicalClaims;
         }else {
             return null;
         }

     }
 }
