package io.springboot.vodainsure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.springboot.vodainsure.utils.CustomDateDeserializer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MotorClaim {

    @Id
    private int motorClaimId;

    @ManyToOne
    @JoinColumn(name = "nationalId")
    @JsonBackReference
    private User user;

    private int motorId;

    private String policyNumber;

    private String claimType;

    private String claimDate;

    private String expiryDate;

    private String clashDate;

    private String make;

    private String amount;

    private  String claimDescription;

    private String driverId;

    private String driverName;
}
