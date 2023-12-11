package io.springboot.vodainsure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @Getter
    @Setter
    private int vehicleId;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nationalId" )
    @JsonBackReference 
    private User user;

    @Getter
    @Setter
    private String registrationNumber;

    @Getter
    @Setter
    private String chasisNumber;

    @Getter
    @Setter
    private String cvNumber;

    @Getter
    @Setter
    private String tonnage;

    @Getter
    @Setter
    private String make;

    @Getter
    @Setter
    private Float vehicleValue;

    @Getter
    @Setter
    private String place;

    @Getter
    @Setter
    private String manufactureYear;

    @Getter
    @Setter
    private String driverId;

    @Getter
    @Setter
    private String driverName;

    @Getter
    @Setter
    private String driverExperience;



}
