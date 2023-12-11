package io.springboot.vodainsure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateMedicalCover {
    
    @Id
     @Getter
    @Setter
    private int corporateId;

    @Getter
    @Setter
    private String companyName;

    @Getter
    @Setter
    private String contactPersonName;

    @Getter
    @Setter
    private String contactPersonPhone;

    @Getter
    @Setter
    private String medicalCoverType;

    @Getter
    @Setter
    private String policyNumber;

    @ManyToOne
    @JoinColumn(name = "nationalId")
    @JsonBackReference
    private User user;

    @Getter
    @Setter
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "corporateMedicalCover", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CorporateMedicalClaim> corporateMedicalClaims= new ArrayList<>();
}
