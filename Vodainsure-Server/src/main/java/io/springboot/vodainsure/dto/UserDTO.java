package io.springboot.vodainsure.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private  int nationalId;

    private String fullName;

    private String email;

    private String phoneNumber;
}
