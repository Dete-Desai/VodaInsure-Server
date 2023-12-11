package io.springboot.vodainsure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Entity
@Data
public class MotorClaim {
    
    @Id
    @Getter
    @Setter  
    private int motorClaimId;

    @ManyToOne
    @JoinColumn(name = "motorId")
    @JsonBackReference
    private MotorCover motorCover;
    @Getter
    @Setter
    private String coverType;
    @Getter
    @Setter
    private String policyNumber;

    @Getter
    @Setter
    private int nationalId;

    @Getter
    @Setter
    private LocalDate claimDate;
    @Getter
    @Setter
    private LocalDate expiryDate;
    @Getter
    @Setter
    private LocalDate clashDate;
    @Getter
    @Setter
    private String make;
    @Getter
    @Setter
    private String driverId;
    @Getter
    @Setter
    private String driverName;
}
