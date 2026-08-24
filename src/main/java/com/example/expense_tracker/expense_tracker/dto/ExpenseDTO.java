package com.example.expense_tracker.expense_tracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExpenseDTO {

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