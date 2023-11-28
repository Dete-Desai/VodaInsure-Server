package io.springboot.vodainsure.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Getter
    @Setter
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nationalId;
    
     @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
   
     private String phoneNumber;
     @Getter
    @Setter
    
      private String country;
    @JsonIgnore
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    @JsonIgnore
    private String roles = "ROLE_USER";


}
