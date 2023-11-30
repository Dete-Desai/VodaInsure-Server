package io.springboot.Voda.Entity;

import java.util.HashSet;
import java.util.Set;

import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="SelfmedicalCover")



public class SelfmedicalCover {
     @jakarta.persistence.Id
	private Integer SelfId;
     
     @Column(name="MembershipType")
     private String MembershipType;
     
     @OneToOne(mappedBy="SelfmedicalCover")
     private User user;
     
     @OneToMany(mappedBy="SelfmedicalCover")
     private Set<SelfmedicalClaims>selfmedicalClaimSet;
     
     @Column(name="familyMembers")
     private int familyMembers;
     
     @Column(name="medicalcoverType")
     private String medicalcoverType;
     
     @Column(name="policy_number")
     private String policy_number;
     
     @Column(name="NationalId")
     private int NationalId;

	public long getId() {
		return SelfId;
	}

	public void setId(Integer id) {
		SelfId = id;
	}

	public String getMembershipType() {
		return MembershipType;
	}

	public void setMembershipType(String membershipType) {
		MembershipType = membershipType;
	}

	public int getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(int familyMembers) {
		this.familyMembers = familyMembers;
	}

	public String getMedicalcoverType() {
		return medicalcoverType;
	}

	public void setMedicalcoverType(String medicalcoverType) {
		this.medicalcoverType = medicalcoverType;
	}

	public String getPolicy_number() {
		return policy_number;
	}

	public void setPolicy_number(String policy_number) {
		this.policy_number = policy_number;
	}

	public int getNationalId() {
		return NationalId;
	}

	public void setNationalId(int nationalId) {
		NationalId = nationalId;
	}

	public SelfmedicalCover(Integer id, String membershipType, int familyMembers, String medicalcoverType,
			String policy_number, int nationalId) {
		super();
		SelfId = id;
		MembershipType = membershipType;
		this.familyMembers = familyMembers;
		this.medicalcoverType = medicalcoverType;
		this.policy_number = policy_number;
		NationalId = nationalId;
	}
     
     public SelfmedicalCover() {
    	 
     }

	@Override
	public String toString() {
		return "SelfmedicalCover [Id=" + SelfId + ", MembershipType=" + MembershipType + ", familyMembers=" + familyMembers
				+ ", medicalcoverType=" + medicalcoverType + ", policy_number=" + policy_number + ", NationalId="
				+ NationalId + "]";
	}
	


    @PrePersist
    public void generateUniqueFourDigitIdAndPolicyNumber() {
        this.SelfId = generateUniqueFourDigitId();
        this.policy_number = SelfmedicalClaims.generateUniquePolicyNumber();
    }

    private static Set<Integer> generatedNumbers = new HashSet<>();

    private Integer generateUniqueFourDigitId() {
        int uniqueNumber;
        do {
            uniqueNumber = ThreadLocalRandom.current().nextInt(1000, 9999);
        } while (!generatedNumbers.add(uniqueNumber));
        return uniqueNumber;
    
}
}






