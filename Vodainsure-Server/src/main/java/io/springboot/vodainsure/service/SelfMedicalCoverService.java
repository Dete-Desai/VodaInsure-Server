package io.springboot.vodainsure.service;

import java.util.List;
import java.util.Random;

import io.springboot.vodainsure.entity.Vehicle;
import io.springboot.vodainsure.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.config.CustomUserDetails;
// import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.SelfMedicalCover;
import io.springboot.vodainsure.entity.User;

import io.springboot.vodainsure.repository.SelfMedicalCoverRepository;


@Service
public class SelfMedicalCoverService {
        @Autowired
    private  SelfMedicalCoverRepository selfMedicalCoverRepository;

    @Autowired
    private UserRepository userRepository;

   
    public SelfMedicalCover saveSelfMedicalCover ( SelfMedicalCover selfMedicalCover){
      

         int randomValue ;
        do {
            randomValue = 100_000 + new Random().nextInt(900_000);
        } while (selfMedicalCoverRepository.existsByselfId(randomValue));


        selfMedicalCover.setSelfId(randomValue);
         CustomUserDetails foundUser = CustomUserDetails.getCurrentUser();
        User currentUser = foundUser.getUser();
        
        
        User user = userRepository.findBynationalId(currentUser.getNationalId());
        selfMedicalCover.setUser(user);
        return  selfMedicalCoverRepository.save(selfMedicalCover);
}

    public SelfMedicalCover getSelfMedicalCover(Integer selfId) {
        SelfMedicalCover selfMedicalCover = selfMedicalCoverRepository.findBySelfId(selfId);
        if (selfMedicalCover != null){
            return selfMedicalCover;
        }
        else {
            return null;
        }
    }
    public List<SelfMedicalCover> getSelfMedicalCovers(Integer nationalId){
//        User currentUser = (User) session.getAttribute("user");
        User user = userRepository.findBynationalId(nationalId);
        if (user != null){
            List<SelfMedicalCover> userSelfMedicalCovers= user.getSelfMedicalCovers();
            return  userSelfMedicalCovers;
        }else {
            return null;
        }

    }


}