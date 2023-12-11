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
public class MotorCover {
    @Id
    @Getter
    @Setter
    private int motorId;

    @ManyToOne
    @JoinColumn(name = "nationalId")
    @JsonBackReference 
    private User user;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

    @Getter
    @Setter
    private String registrationNumber;
    @Getter
    @Setter
    private String policyNumber;

     @Getter
    @Setter
    private LocalDate coverExpiryDate;

    @Getter
    @Setter
     private LocalDate coverRenewalDate;

     @Getter
    @Setter
     private String coverType;

    @Getter
    @Setter
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "motorCover", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MotorClaim> motorClaims = new ArrayList<>();

}
