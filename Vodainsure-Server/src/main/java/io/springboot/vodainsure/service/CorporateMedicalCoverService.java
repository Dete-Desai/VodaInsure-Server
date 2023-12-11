package io.springboot.vodainsure.service;

import java.util.List;
import java.util.Random;

import io.springboot.vodainsure.entity.SelfMedicalCover;
import io.springboot.vodainsure.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.CorporateMedicalCover;

import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.repository.CorporateMedicalCoverRepository;


@Service
public class CorporateMedicalCoverService {
            @Autowired
    private UserRepository userRepository;

    @Autowired
    private  CorporateMedicalCoverRepository corporateMedicalCoverRepository;

   

        public CorporateMedicalCover saveCorporateMedicalCover (HttpSession session, CorporateMedicalCover corporateMedicalCover){


            int randomValue ;
            do {
                randomValue = 100_000 + new Random().nextInt(900_000);
            } while (corporateMedicalCoverRepository.existsBycorporateId(randomValue));


            corporateMedicalCover.setCorporateId(randomValue);
            User currentUser = (User) session.getAttribute("user");
            User user = userRepository.findBynationalId(currentUser.getNationalId());
            corporateMedicalCover.setUser(user);
            return  corporateMedicalCoverRepository.save(corporateMedicalCover);
        }

        public CorporateMedicalCover getCorporateMedicalCover(Integer corporateId) {
            CorporateMedicalCover corporateMedicalCover = corporateMedicalCoverRepository.findByCorporateId(corporateId);
            if (corporateMedicalCover != null){
                return corporateMedicalCover;
            }
            else {
                return null;
            }
        }
        public List<CorporateMedicalCover> getCorporateMedicalCovers(Integer nationalId){
//        User currentUser = (User) session.getAttribute("user");
            User user = userRepository.findBynationalId(nationalId);
            if (user != null){
                List<CorporateMedicalCover> userCorporateMedicalCovers= user.getCorporateMedicalCovers();
                return  userCorporateMedicalCovers;
            }else {
                return null;
            }

        }

}
