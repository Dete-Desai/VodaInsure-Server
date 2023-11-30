package io.springboot.Voda.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="MotorClaims")

public class MotorClaims {
@Id
private Long ClaimId;

@Column(name="MotorID")
private int MotorID;

@Column(name="Registration_number")
private String Registration_number;

@Column(name="Cover_type")
private String Cover_type;

@Column(name="policy_number")
private String policy_number;

@Column(name="Claimdate")
private LocalDateTime Claimdate;

@Column(name="NationalId")
private int NationalId;

@Column(name="Clashdate")
private LocalDateTime Clashdate;

@Column(name="expirydate")
private LocalDateTime expirydate;

@Column(name="Vehicle_category")
private String Vehicle_category;

@Column(name="Driver_ID")
private String Driver_ID;

@Column(name="Driver_Name")
private String Driver_Name;

public Long getClaimId() {
	return ClaimId;
}

public void setClaimId(Long claimId) {
	ClaimId = claimId;
}

public int getMotorID() {
	return MotorID;
}

public void setMotorID(int motorID) {
	MotorID = motorID;
}

public String getRegistration_number() {
	return Registration_number;
}

public void setRegistration_number(String registration_number) {
	Registration_number = registration_number;
}

public String getCover_type() {
	return Cover_type;
}

public void setCover_type(String cover_type) {
	Cover_type = cover_type;
}

public String getPolicy_number() {
	return policy_number;
}

public void setPolicy_number(String policy_number) {
	this.policy_number = policy_number;
}

public LocalDateTime getClaimdate() {
	return Claimdate;
}

public void setClaimdate(LocalDateTime claimdate) {
	Claimdate = claimdate;
}

public int getNationalId() {
	return NationalId;
}

public void setNationalId(int nationalId) {
	NationalId = nationalId;
}

public LocalDateTime getClashdate() {
	return Clashdate;
}

public void setClashdate(LocalDateTime clashdate) {
	Clashdate = clashdate;
}

public LocalDateTime getExprirydate() {
	return expirydate;
}

public void setExprirydate(LocalDateTime exprirydate) {
	this.expirydate = exprirydate;
}

public String getVehicle_category() {
	return Vehicle_category;
}

public void setVehicle_category(String vehicle_category) {
	Vehicle_category = vehicle_category;
}

public String getDriver_ID() {
	return Driver_ID;
}

public void setDriver_ID(String driver_ID) {
	Driver_ID = driver_ID;
}

public String getDriver_Name() {
	return Driver_Name;
}

public void setDriver_Name(String driver_Name) {
	Driver_Name = driver_Name;
}

public MotorClaims(Long claimId, int motorID, String registration_number, String cover_type, String policy_number,
		LocalDateTime claimdate, int nationalId, LocalDateTime clashdate, LocalDateTime exprirydate,
		String vehicle_category, String driver_ID, String driver_Name) {
	super();
	ClaimId = claimId;
	MotorID = motorID;
	Registration_number = registration_number;
	Cover_type = cover_type;
	this.policy_number = policy_number;
	Claimdate = claimdate;
	NationalId = nationalId;
	Clashdate = clashdate;
	expirydate = exprirydate;
	Vehicle_category = vehicle_category;
	Driver_ID = driver_ID;
	Driver_Name = driver_Name;
}

public MotorClaims() {
	
}

@Override
public String toString() {
	return "MotorClaims [ClaimId=" + ClaimId + ", MotorID=" + MotorID + ", Registration_number=" + Registration_number
			+ ", Cover_type=" + Cover_type + ", policy_number=" + policy_number + ", Claimdate=" + Claimdate
			+ ", NationalId=" + NationalId + ", Clashdate=" + Clashdate + ", expirydate=" + expirydate
			+ ", Vehicle_category=" + Vehicle_category + ", Driver_ID=" + Driver_ID + ", Driver_Name=" + Driver_Name
			+ "]";
}


@PrePersist
public void generateUniqueFiveDigitId1() {
    this.ClaimId = generateUniqueFiveDigitId();
}

private static long generateUniqueFiveDigitId() {
    return Long.parseLong(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5));
}

}

