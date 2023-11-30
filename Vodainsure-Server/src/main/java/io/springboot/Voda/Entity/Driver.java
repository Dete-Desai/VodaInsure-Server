package io.springboot.Voda.Entity;



import java.util.HashSet;
import java.util.Set;

import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Driver")
public class Driver {
	
	@Id
	@Column(name="DriverID")
	private Integer DriverID;
	

	 @ManyToOne(cascade = CascadeType.PERSIST)
	    @JoinColumn(name="VinId", referencedColumnName="VinId") // Foreign key column in Driver referencing VinId in Motor
	    private io.springboot.Voda.Entity.Motor motor;
	 public void setMotor(io.springboot.Voda.Entity.Motor existingMotor) {
	        this.motor = existingMotor;
	    }
	
	@Column(name="VehicleType")
	private String VehicleType;
	
	@Column(name="DriverExperience")
	private String DriverExperience;
	
	

	public long getDriverID() {
		return DriverID;
	}

	public void setDriverID(Integer driverID) {
		DriverID = driverID;
	}

	public String getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}

	public String getDriverExperience() {
		return DriverExperience;
	}

	public void setDriverExperience(String driverExperience) {
		DriverExperience = driverExperience;
	}

	

	public Driver(Integer driverID, String vehicleType, String driverExperience, String registrationNumber) {
		super();
		DriverID = driverID;
		VehicleType = vehicleType;
		DriverExperience = driverExperience;
		
	}
	
	public Driver() {
		
	}

	@Override
	public String toString() {
		return "Driver [DriverID=" + DriverID + ", VehicleType=" + VehicleType + ", DriverExperience="
				+ DriverExperience +"]";
	}

	@PrePersist
	public void generateUniqueEightDigitId1() {
	    this.DriverID = generateUniqueEightDigitId();
	}

	private static Set<Integer> generatedNumbers = new HashSet<>();

	private Integer generateUniqueEightDigitId() {
	    int uniqueNumber;
	    do {
	        uniqueNumber = ThreadLocalRandom.current().nextInt(10000000, 99999999);
	    } while (!generatedNumbers.add(uniqueNumber));

	    return uniqueNumber;

	}


	

	public class Motor {
	    private Integer vinId;

		// Other fields...

	    public Motor(Integer vinId) {
	        this.setVinId(vinId);
	    }

		public Integer getVinId() {
			return vinId;
		}

		public void setVinId(Integer vinId) {
			this.vinId = vinId;
		}

	    // Other methods...
	}




	public io.springboot.Voda.Entity.Motor getMotor() {
		// TODO Auto-generated method stub
		return null;
	}






	}

  

