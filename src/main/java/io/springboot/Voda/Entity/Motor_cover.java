package io.springboot.Voda.Entity;

import java.time.LocalDate;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Motor_cover")

public class Motor_cover {
	 // create table Motor_cover(MotorID int Auto_increment primary Key, vehicle_category varchar(20) Not Null, registration_number varchar(20) Not Null, chasis_number varchar(20) Not Null, cv_number varchar
			    //(20) Not Null, tonnage varchar(20) Not Null, vehicle_value float Not Null, manufacture_year Year Not Null, Driver_ID int(20) Not Null, experience varchar(20) Not Null, policy_number varchar(20) Not Null, NationalId int, cover_type varchar(20) Not Null, cover_renewal_date Date Not Null, cover_expiry_date Date Not Null);
			  //  drop table Motor_cover;
	
@Id

private Long MotorID;//six-digit Auto-generated

@Column(name="Motor_Category")
private String Motor_category;

@Column(name="Registration_number")
private String Registration_number;

@Column(name="Chasis_number")
private String Chasis_Number;

@Column(name="Cv_number")
private String Cv_number;

@Column(name="Tonnage")
private String Tonnage;

@Column(name="Vehicle_value")
private float vehicle_value;

@Column(name="manufacture_year")
private int manufacture_year;

@Column(name="Driver_ID")
private int Driver_ID;

@Column(name="Experience")
private String Experience;

@Column(name="NationalId")
private int NationalId;

@Column(name="policy_number")
private String policy_number;

@Column(name="Cover_type")
private String Cover_type;

@Column(name="Renewaldate")
private LocalDate Renewaldate ;//cover_Renewaldate

@Column(name="Expirydate")
private LocalDate Expirydate;//cover_exprirydate

public Long getMotorID() {
	return MotorID;
}

public void setMotorID(Long motorID) {
	MotorID = motorID;
}

public String getMotor_category() {
	return Motor_category;
}

public void setMotor_category(String motor_category) {
	Motor_category = motor_category;
}

public String getRegistration_number() {
	return Registration_number;
}

public void setRegistration_number(String registration_number) {
	Registration_number = registration_number;
}

public String getChasis_Number() {
	return Chasis_Number;
}

public void setChasis_Number(String chasis_Number) {
	Chasis_Number = chasis_Number;
}

public String getCv_number() {
	return Cv_number;
}

public void setCv_number(String cv_number) {
	Cv_number = cv_number;
}

public String getTonnage() {
	return Tonnage;
}

public void setTonnage(String tonnage) {
	Tonnage = tonnage;
}

public float getVehicle_value() {
	return vehicle_value;
}

public void setVehicle_value(float vehicle_value) {
	this.vehicle_value = vehicle_value;
}

public int getManufacture_year() {
	return manufacture_year;
}

public void setManufacture_year(int manufacture_year) {
	this.manufacture_year = manufacture_year;
}

public int getDriver_ID() {
	return Driver_ID;
}

public void setDriver_ID(int driver_ID) {
	Driver_ID = driver_ID;
}

public String getExperience() {
	return Experience;
}

public void setExperience(String experience) {
	Experience = experience;
}

public int getNationalId() {
	return NationalId;
}

public void setNationalId(int nationalId) {
	NationalId = nationalId;
}

public String getPolicy_number() {
	return policy_number;
}

public void setPolicy_number(String policy_number) {
	this.policy_number = policy_number;
}

public String getCover_type() {
	return Cover_type;
}

public void setCover_type(String cover_type) {
	Cover_type = cover_type;
}

public LocalDate getRenewaldate() {
	return Renewaldate;
}

public void setRenewaldate(LocalDate renewaldate) {
	Renewaldate = renewaldate;
}

public LocalDate getExpirydate() {
	return Expirydate;
}

public void setExpirydate(LocalDate expirydate) {
	this.Expirydate = expirydate;
}

public Motor_cover(Long motorID, String motor_category, String registration_number, String chasis_Number,
		String cv_number, String tonnage, float vehicle_value, int manufacture_year, int driver_ID, String experience,
		int nationalId, String policy_number, String cover_type, LocalDate renewaldate, LocalDate expirydate) {
	super();
	MotorID = motorID;
	Motor_category = motor_category;
	Registration_number = registration_number;
	Chasis_Number = chasis_Number;
	Cv_number = cv_number;
	Tonnage = tonnage;
	this.vehicle_value = vehicle_value;
	this.manufacture_year = manufacture_year;
	Driver_ID = driver_ID;
	Experience = experience;
	NationalId = nationalId;
	this.policy_number = policy_number;
	Cover_type = cover_type;
	Renewaldate = renewaldate;
	this.Expirydate = expirydate;
}
public Motor_cover(){
	
	
}


@Override
public String toString() {
	return "Motor_cover [MotorID=" + MotorID + ", Motor_category=" + Motor_category + ", Registration_number="
			+ Registration_number + ", Chasis_Number=" + Chasis_Number + ", Cv_number=" + Cv_number + ", Tonnage="
			+ Tonnage + ", vehicle_value=" + vehicle_value + ", manufacture_year=" + manufacture_year + ", Driver_ID="
			+ Driver_ID + ", Experience=" + Experience + ", NationalId=" + NationalId + ", policy_number="
			+ policy_number + ", Cover_type=" + Cover_type + ", Renewaldate=" + Renewaldate + ", expirydate="
			+ Expirydate + "]";
}

@PrePersist
public void generateSixDigitId() {
    // Generate a random six-digit number
    this.MotorID = (long) generateRandomNumber();
}
private static int generateRandomNumber() {
    Random random = new Random();
    return random.nextInt(900000) + 100000;
}
}
