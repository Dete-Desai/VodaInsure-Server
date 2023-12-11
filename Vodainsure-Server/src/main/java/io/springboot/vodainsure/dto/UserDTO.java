package io.springboot.vodainsure.dto;


import lombok.Data;
import lombok.Setter;

@Data
public class UserDTO {
    
    @Setter
    private String fullName;
    
    @Setter
    private String email;
   
    @Setter   
    private String phoneNumber;
}
