package io.springboot.vodainsure.entity;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Data
public class MotorCover {
    @Id
    @Getter
    @Setter
    private int motorId;

     @ManyToOne
    @JoinColumn(name = "NationalId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vehicleid")
    private Vehicle vehicle;
    @Getter
    @Setter
    private String policynumber;

     @Getter
    @Setter
    private LocalDate coverExpiryDate;

    @Getter
    @Setter
     private LocalDate coverRenewalDate;

     @Getter
    @Setter
     private String coverType;
}
