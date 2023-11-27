package io.springboot.Voda.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")

public class User {
	
	@Id
	private Integer NationalId;
	
	@Column(name="Fullname")
	private String Fullname;
	

	@Column(name="Email")
	private String Email;
	

	@Column(name="Phonenumber")
	private String Phonenumber;
	

	@Column(name="Country")
	private String Country;
	
	

	@Column(name="Password")
	private String Password;



	public Integer getNationalId() {
		return NationalId;
	}



	public void setNationalId(Integer nationalId) {
		NationalId = nationalId;
	}



	public String getFullname() {
		return Fullname;
	}



	public void setFullname(String fullname) {
		Fullname = fullname;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getPhonenumber() {
		return Phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}



	public String getCountry() {
		return Country;
	}



	public void setCountry(String country) {
		Country = country;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public User(Integer nationalId, String fullname, String email, String phonenumber, String country,
			String password) {
		super();
		NationalId = nationalId;
		Fullname = fullname;
		Email = email;
		Phonenumber = phonenumber;
		Country = country;
		Password = password;
	}
	
	public User() {
		
	}



	@Override
	public String toString() {
		return "User [NationalId=" + NationalId + ", Fullname=" + Fullname + ", Email=" + Email + ", Phonenumber="
				+ Phonenumber + ", Country=" + Country + ", Password=" + Password + "]";
	}
	
	

}
