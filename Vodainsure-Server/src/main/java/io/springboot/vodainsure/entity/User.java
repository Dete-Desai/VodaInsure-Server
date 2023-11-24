package io.springboot.vodainsure.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
