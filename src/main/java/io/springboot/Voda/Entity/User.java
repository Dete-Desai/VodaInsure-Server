package io.springboot.Voda.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "NationalId")
    private Integer NationalId;

    @OneToOne(mappedBy = "user")
    private SelfmedicalCover selfmedicalCover;

    @ManyToMany(mappedBy = "users")
    private Set<SelfmedicalClaims> selfmedicalClaimsSet;

    @Column(name = "Fullname")
    private String Fullname;

    @Column(name = "Email")
    private String email;  // Corrected variable name

    @Column(name = "Phonenumber")
    private String phonenumber;  // Corrected variable name

    @Column(name = "Country")
    private String Country;

    @Column(name = "Password")
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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;  // Use 'this' to refer to the instance variable
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;  // Use 'this' to refer to the instance variable
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

    public User(Integer nationalId, String fullname, String email, String phonenumber, String country, String password) {
        super();
        NationalId = nationalId;
        Fullname = fullname;
        this.email = email;
        this.phonenumber = phonenumber;
        Country = country;
        Password = password;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User [NationalId=" + NationalId + ", Fullname=" + Fullname + ", Email=" + email + ", Phonenumber="
                + phonenumber + ", Country=" + Country + ", Password=" + Password + "]";
    }
}
