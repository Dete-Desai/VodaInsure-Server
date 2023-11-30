package io.springboot.Voda.Entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="CorporateMedicalClaims")

public class CorporateMedicalClaims {
	
 
@Id
	private Long CorporatemedicalClaimId;

@Column(name="CorporateId")
private int CorporateId;

@Column(name="ClaimDate")
private LocalDate ClaimDate;

@Column(name="ClaimStatus")
private String ClaimStatus;

@Column(name="ClaimAmount")
private  float ClaimAmount;

@Column(name="Claimdescription")
private String ClaimDescription;

@Column(name="claimType")
private  String claimType;

@Column(name="DocumentLink")
private String DocumentLink;

@Column(name="policy_number")
private String Policy_number;

@Column(name="NationalId")
private String NationalId;

public Long getCorporatemedicalClaimId() {
	return CorporatemedicalClaimId;
}

public void setCorporatemedicalClaimId(Long corporatemedicalClaimId) {
	CorporatemedicalClaimId = corporatemedicalClaimId;
}

public int getCorporateId() {
	return CorporateId;
}

public void setCorporateId(int corporateId) {
	CorporateId = corporateId;
}

public LocalDate getClaimDate() {
	return ClaimDate;
}

public void setClaimDate(LocalDate claimDate) {
	ClaimDate = claimDate;
}

public String getClaimStatus() {
	return ClaimStatus;
}

public void setClaimStatus(String claimStatus) {
	ClaimStatus = claimStatus;
}

public float getClaimAmount() {
	return ClaimAmount;
}

public void setClaimAmount(float claimAmount) {
	ClaimAmount = claimAmount;
}

public String getClaimDescription() {
	return ClaimDescription;
}

public void setClaimDescription(String claimDescription) {
	ClaimDescription = claimDescription;
}

public String getClaimType() {
	return claimType;
}

public void setClaimType(String claimType) {
	this.claimType = claimType;
}

public String getDocumentLink() {
	return DocumentLink;
}

public void setDocumentLink(String documentLink) {
	DocumentLink = documentLink;
}

public String getPolicy_number() {
	return Policy_number;
}

public void setPolicy_number(String policy_number) {
	Policy_number = policy_number;
}

public String getNationalId() {
	return NationalId;
}

public void setNationalId(String nationalId) {
	NationalId = nationalId;
}

public CorporateMedicalClaims(Long corporatemedicalClaimId, int corporateId, LocalDate claimDate, String claimStatus,
		float claimAmount, String claimDescription, String claimType, String documentLink, String policy_number,
		String nationalId) {
	super();
	CorporatemedicalClaimId = corporatemedicalClaimId;
	CorporateId = corporateId;
	ClaimDate = claimDate;
	ClaimStatus = claimStatus;
	ClaimAmount = claimAmount;
	ClaimDescription = claimDescription;
	this.claimType = claimType;
	DocumentLink = documentLink;
	Policy_number = policy_number;
	NationalId = nationalId;
}

public CorporateMedicalClaims() {
	
}

@Override
public String toString() {
	return "CorporateMedicalClaims [CorporatemedicalClaimId=" + CorporatemedicalClaimId + ", CorporateId=" + CorporateId
			+ ", ClaimDate=" + ClaimDate + ", ClaimStatus=" + ClaimStatus + ", ClaimAmount=" + ClaimAmount
			+ ", ClaimDescription=" + ClaimDescription + ", claimType=" + claimType + ", DocumentLink=" + DocumentLink
			+ ", Policy_number=" + Policy_number + ", NationalId=" + NationalId + "]";
}
	
@PrePersist
public void generateUniqueSevenDigitId1() {
    this.CorporatemedicalClaimId = generateUniqueSevenDigitId();
}

private static long generateUniqueSevenDigitId() {
    return Long.parseLong(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7));
}

}
