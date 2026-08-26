package com.example.expense_tracker.expense_tracker.controller;

import com.example.expense_tracker.expense_tracker.dto.ExpenseDTO;
import com.example.expense_tracker.expense_tracker.dto.Expensesummary;
import com.example.expense_tracker.expense_tracker.model.Expense;
import com.example.expense_tracker.expense_tracker.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


//        --------------- get all expenses ------------

    @GetMapping
    public ResponseEntity<Page<ExpenseDTO>> getallexpenses(Pageable pageable){

        Page<ExpenseDTO> ex =expenseService.getallexpenses(pageable);

        return ResponseEntity.ok(ex);

    }


//    --------------- get by id -----------------

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getexpensesbyId(@PathVariable("id") int id){

        ExpenseDTO ex = expenseService.getexpensesbyId(id);

        return ResponseEntity.ok(ex);
    }


//    ---------------- search by category amount description -----------------

    @GetMapping("/search")
    public ResponseEntity<Page<ExpenseDTO>>  serachbyall( @RequestParam String query,Pageable pageable){

        Page<ExpenseDTO> ex= expenseService.searchall(query,pageable);

        return ResponseEntity.ok(ex);



    }



//    --------------------------- post the expenses -----------------------------------

    @PostMapping("/post")
    public ResponseEntity<String> postexpense(@RequestBody Expense ex){

        expenseService.postexpenses(ex);

        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }


//    --------------------- update the expenses ---------------------------------------------

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateexpense(@PathVariable("id") int id,@RequestBody Expense ex){

        expenseService.updateexpenses(id,ex);

        return ResponseEntity.status(HttpStatus.CREATED).body("successfully updated");
    }



//    ------------------------ delete the expenses ---------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteexpense(){

        expenseService.deleteexpenses();

        return ResponseEntity.ok("successfully deleted");


    }


    //    ------------------------ delete the expenses by id ---------------------------------------


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){

        expenseService.deleteById(id);

        return ResponseEntity.ok("successfully deleted");
    }


//    ----------------------------- summary ------------------------------------------------------

    @GetMapping("/summary")
    public ResponseEntity<List<Expensesummary>> summary(@RequestParam String year, @RequestParam String month){

        List<Expensesummary> expenses= expenseService.summary(year,month);

        return ResponseEntity.ok(expenses);




    }



}
