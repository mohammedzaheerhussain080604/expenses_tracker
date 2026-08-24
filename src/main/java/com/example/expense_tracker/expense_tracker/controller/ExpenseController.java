package com.example.expense_tracker.expense_tracker.controller;

import com.example.expense_tracker.expense_tracker.dto.ExpenseDTO;
import com.example.expense_tracker.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myexpenses")
public class ExpenseController {

    ExpenseService expenseService;

    ExpenseController(ExpenseService expenseService){


        this.expenseService = expenseService;
    }

//    --------------- get request -----------


//        --------------- get all expensese ------------

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getallexpenses(){

        List<ExpenseDTO> ex =expenseService.getallexpenses();

        return ResponseEntity.ok(ex);

    }


//    --------------- get by id -----------------

    @GetMapping("/{id}")
    public ResponseEntity<List<ExpenseDTO>> getexpensesbyId(@PathVariable("id") int id){

        List<ExpenseDTO> ex = expenseService.getexpensesbyId(id);

        return ResponseEntity.ok(ex);
    }


}
