package io.springboot.vodainsure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelfMedicalClaim {
    

    @Id
    @Getter
    @Setter
    private int selfClaimId;

     @ManyToOne
    @JoinColumn(name = "selfId")
    private SelfMedicalCover selfMedicalCover;

     @ManyToOne
    @JoinColumn(name = "nationalId")
    private User user;
    @Getter
    @Setter
    private LocalDate claimDate;

    @Getter
    @Setter
    private String claimStatus;

    @Getter
    @Setter
    private float claimAmount;

    @Getter
    @Setter
    private String claimDescription;

    @Getter
    @Setter
    private String claimType;

    @Getter
    @Setter
    private String documentLink;

    @Getter
    @Setter
    private String policyNumber;

}
