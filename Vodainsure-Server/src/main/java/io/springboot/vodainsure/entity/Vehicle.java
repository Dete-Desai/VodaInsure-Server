package io.springboot.vodainsure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private int vehicleid;

    @ManyToOne
    @JoinColumn(name = "NationalId")
    private User user;

    @Getter
    @Setter
    private String registration_number;

    @Getter
    @Setter
    private String chasis_number;

    @Getter
    @Setter
    private String cv_number;

    @Getter
    @Setter
    private Float vehicle_value;

    @Getter
    @Setter
    private String manufacture_year;

    @Getter
    @Setter
    private String driver_id;

    @Getter
    @Setter
    private String driver_experience;


    public void setUser(User user) {
        this.user = user;
    }

}
