package com.example.expense_tracker.expense_tracker.model;
import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotBlank(message = "enter the category ")
    private String category;


    @NotNull(message = "enter the amount")
    @Positive(message = "amount should be positive ")
    private int amount;

    @NotBlank(message = "enter the description ")
    private String description;

    @NotNull(message = "enter the date ")
    private LocalDateTime datetime;

}
