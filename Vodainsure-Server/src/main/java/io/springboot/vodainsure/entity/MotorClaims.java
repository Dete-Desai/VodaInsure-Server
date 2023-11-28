package io.springboot.vodainsure.entity;

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
public class MotorClaims {
    
    @Id
    @Getter
    @Setter  
    private int motorClaimId;

    @ManyToOne
    @JoinColumn(name = "motorId")
    private MotorCover motorCover;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;
    private String coverType;
    private String policyNumber;
    private LocalDate claimDate;
    private LocalDate expiryDate;
    private LocalDate clashDate;
    private String vehicleCategory;
    private int driverId;
    private String driverName;
}
