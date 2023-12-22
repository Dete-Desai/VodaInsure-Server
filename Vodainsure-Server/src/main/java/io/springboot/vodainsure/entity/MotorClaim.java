package io.springboot.vodainsure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.springboot.vodainsure.utils.CustomDateDeserializer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Data
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

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private LocalDate claimDate;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private LocalDate expiryDate;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private LocalDate clashDate;

    private String make;

    private String amount;

    private  String claimDescription;

    private String driverId;

    private String driverName;
}
