package com.example.expense_tracker.expense_tracker.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message="Enter the name")
    private String name;


    @NotNull(message="Enter the email")
    @Email(message = "enter the valis email")
    @Column(unique = true,nullable = false)
    private String email;



    @NotNull(message="Enter the password")
    @Size(min = 8,max=16,message = "Password must be 8-16 characters")
    private String password;


}
