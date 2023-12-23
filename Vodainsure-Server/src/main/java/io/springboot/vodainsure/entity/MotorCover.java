package io.springboot.vodainsure.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
 @Getter
    @Setter
public class MotorCover {   
    @Id
    private int motorId;

    @ManyToOne
    @JoinColumn(name = "nationalId")
    @JsonBackReference 
    private User user;


    @OneToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;


    private String registrationNumber;

    private String policyNumber;

 
    private String coverExpiryDate;


     private String coverRenewalDate;

 
     private String coverType;




}
