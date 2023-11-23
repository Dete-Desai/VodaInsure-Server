package io.springboot.web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")

public class User {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
@Column(name="Fullname")
	private String Fullname;
@Column(name="Email")
	private String Email;
@Column(name="phonenumber")
	private String phonenumber;
@Column(name="country")
	private String Country;
@Column(name="password")
	private String password;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
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
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User(Long id, String fullname, String email, String phonenumber, String country, String password) {
	super();
	this.id = id;
	Fullname = fullname;
	Email = email;
	this.phonenumber = phonenumber;
	Country = country;
	this.password = password;
}
public User() {
	
}
@Override
public String toString() {
	return "User [id=" + id + ", Fullname=" + Fullname + ", Email=" + Email + ", phonenumber=" + phonenumber
			+ ", Country=" + Country + ", password=" + password + "]";
}
}