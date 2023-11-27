package io.springboot.vodainsure.entity;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class User {
    @Id
    @Getter
    @Setter
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int NationalId;
    @Getter
    @Setter
    
    private String fullname;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
   
     private String phonenumber;
     @Getter
    @Setter
    
      private String country;
      @Getter
    @Setter
    
    private String password;

        @Getter
    @Setter
    private String roles = "ROLE_USER";
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private Set<Vehicle> vehicles = new HashSet<>(); 
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.setUser(this);
    }
}
