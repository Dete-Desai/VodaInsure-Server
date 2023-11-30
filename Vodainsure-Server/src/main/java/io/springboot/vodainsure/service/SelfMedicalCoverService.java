package io.springboot.vodainsure.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.vodainsure.config.MyUserDetails;
import io.springboot.vodainsure.entity.SelfMedicalCover;
import io.springboot.vodainsure.entity.User;

import io.springboot.vodainsure.repository.SelfMedicalCoverRepository;


@Service
public class SelfMedicalCoverService {
        @Autowired
    private  SelfMedicalCoverRepository selfMedicalCoverRepository;

   
    public SelfMedicalCover saveSelfMedicalCover (SelfMedicalCover selfMedicalCover){
      

         int randomValue ;
        do {
            randomValue = 100_000 + new Random().nextInt(900_000);
        } while (selfMedicalCoverRepository.existsByselfId(randomValue));

        
        selfMedicalCover.setSelfId(randomValue);
        MyUserDetails currentUser = MyUserDetails.getCurrentUser();
        User user = currentUser.getUser();
        selfMedicalCover.setUser(user);
        return  selfMedicalCoverRepository.save(selfMedicalCover);
}
}