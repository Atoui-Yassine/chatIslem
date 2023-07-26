package com.example.chatIslem.DTOs.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
@Data
public class SignupRequest {

    @NotBlank
    @Size(max = 30)
    private  String firstname;
    @NotBlank
    @Size(max = 30)
    private  String lastname;
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    private Set<String> roles;


}
