package com.example.expense_tracker.expense_tracker.exception;

public class  ExpenseNotFoundException extends RuntimeException{

    public ExpenseNotFoundException(String message){

        super(message);

    }
}
