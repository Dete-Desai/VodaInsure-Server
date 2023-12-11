package io.springboot.vodainsure.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelfMedicalCover {

    @Id
    @Getter
    @Setter
    private int selfId;
    @ManyToOne
    @JoinColumn(name = "nationalId")
    @JsonBackReference
    private User user;

    @Getter
    @Setter
    private String membershipType;

    @Getter
    @Setter
    private int familyMembers;

    @Getter
    @Setter
    private String medicalCoverType;

    @Getter
    @Setter
    private String policyNumber;

    @Getter
    @Setter
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "selfMedicalCover", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SelfMedicalClaim> selfMedicalClaims= new ArrayList<>();

}
