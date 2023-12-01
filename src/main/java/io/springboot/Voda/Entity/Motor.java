package io.springboot.Voda.Entity;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Motor")
public class Motor {
	
	@Id
	
	private Integer VinId;//vehicle identificationNumber

	
	
	 @OneToMany(mappedBy="motor") // mappedBy should match the variable name in Driver referring to Motor
	    private List<Driver> drivers;
	 
	 public List<Driver>getDrivers() {
	        return drivers;
	 }
	 public void setDrivers(List<Driver> drivers) {
	        this.drivers = drivers;
	 }
	
	@Column(name="RegistrationNumber")
	private String RegistrationNumber;
	
	@Column(name="owner")
	private String owner;
	
	@Column(name="NationalId")
	private Integer NationalId;
	
	@Column(name="manufactureyear")
	private Integer manufactureyear;
	
	@Column(name="chasis_number")
	private String chasis_number;
	
	@Column(name="motorValue")
	private float motorValue;
	
	@Column(name="Cv_number")
	private String Cv_number;

	public Integer getVinId() {
		return VinId;
	}

	public void setVinId(Integer vinId) {
		VinId = vinId;
	}

	public String getRegistrationNumber() {
		return RegistrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		RegistrationNumber = registrationNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getNationalId() {
		return NationalId;
	}

	public void setNationalId(int nationalId) {
		NationalId = nationalId;
	}

	public Integer getManufactureyear() {
		return manufactureyear;
	}

	public void setManufactureyear(Integer manufactureyear) {
		this.manufactureyear = manufactureyear;
	}

	public String getChasis_number() {
		return chasis_number;
	}

	public void setChasis_number(String chasis_number) {
		this.chasis_number = chasis_number;
	}

	public float getMotorValue() {
		return motorValue;
	}

	public void setMotorValue(float motorValue) {
		this.motorValue = motorValue;
	}

	public String getCv_number() {
		return Cv_number;
	}

	public void setCv_number(String cv_number) {
		Cv_number = cv_number;
	}

	
	
	


	
	
	public Motor(Integer vinId, String registrationNumber, String owner, int nationalId, Integer manufactureyear,
			String chasis_number, float motorValue, String cv_number) {
		super();
		VinId = vinId;
		RegistrationNumber = registrationNumber;
		this.owner = owner;
		NationalId = nationalId;
		this.manufactureyear = manufactureyear;
		this.chasis_number = chasis_number;
		this.motorValue = motorValue;
		Cv_number = cv_number;
	}

	public Motor() {
		
	}

	@Override
	public String toString() {
		return "Motor [VinId=" + VinId + ", RegistrationNumber=" + RegistrationNumber + ", owner=" + owner
				+ ", NationalId=" + NationalId + ", manufactureyear=" + manufactureyear + ", chasis_number="
				+ chasis_number + ", motorValue=" + motorValue + ", Cv_number=" + Cv_number + "]";
	}

	 @PrePersist
	    public void generateUniqueThreeDigitId1() {
	        this.VinId = generateUniqueThreeDigitId();
	    }
	 private static Set<Integer> generatedNumbers = new HashSet<>();

	  private Integer generateUniqueThreeDigitId() {
	        int uniqueNumber;
	        do {
	        uniqueNumber = ThreadLocalRandom.current().nextInt(100, 1000);
	        } while (!generatedNumbers.add(uniqueNumber));

	        return uniqueNumber;
	    }



	  }

