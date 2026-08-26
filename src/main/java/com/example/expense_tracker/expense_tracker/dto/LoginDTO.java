package com.example.expense_tracker.expense_tracker.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class LoginDTO {



    @NotBlank(message="Enter the email")
    @Email(message = "enter the valis email")
    @Column(unique = true,nullable = false)
    private String email;



    @NotBlank(message="Enter the password")
    @Size(min = 8,max=16,message = "Password must be 8-16 characters")
    private String password;

}
