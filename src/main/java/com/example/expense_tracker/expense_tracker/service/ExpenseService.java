package com.example.expense_tracker.expense_tracker.service;


import com.example.expense_tracker.expense_tracker.dto.ExpenseDTO;
import com.example.expense_tracker.expense_tracker.dto.Expensesummary;
import com.example.expense_tracker.expense_tracker.exception.ExpenseNotFoundException;
import com.example.expense_tracker.expense_tracker.model.Expense;
import com.example.expense_tracker.expense_tracker.repository.ExpenseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    ExpenseRepo expenseRepo;

    ExpenseService(ExpenseRepo expenseRepo){

        this.expenseRepo=expenseRepo;
    }



//    --------------- get request -----------


//        --------------- get all expenses ------------
public Page<ExpenseDTO> getallexpenses(Pageable pageable) {

    Page<Expense> expenses = expenseRepo.findAll(pageable);

    return expenses.map(ex -> {

        ExpenseDTO dto = new ExpenseDTO();

        dto.setCategory(ex.getCategory());
        dto.setAmount(ex.getAmount());
        dto.setDescription(ex.getDescription());
        dto.setDatetime(ex.getDatetime());

        return dto;
    });
}


    //    --------------- get by id -----------------

    public ExpenseDTO getexpensesbyId(int id) {

        Expense expenses= expenseRepo.findById(id).orElseThrow(()->new ExpenseNotFoundException());

        ExpenseDTO dto = new ExpenseDTO();

        dto.setCategory(expenses.getCategory());
        dto.setDescription(expenses.getDescription());
        dto.setAmount(expenses.getAmount());
        dto.setDatetime(expenses.getDatetime());

        return dto;
    }

    //    ---------------- search by category amount description -----------------

    public Page<ExpenseDTO> searchall(String query, Pageable pageable) {

        Page<Expense> expenses =
                expenseRepo.searchExpenses(query,pageable);

        return expenses.map(ex -> {

            ExpenseDTO dto = new ExpenseDTO();

            dto.setCategory(ex.getCategory());
            dto.setDescription(ex.getDescription());
            dto.setAmount(ex.getAmount());
            dto.setDatetime(ex.getDatetime());

            return dto;
        });
    }

    //    --------------------------- post the expenses -----------------------------------
    public void postexpenses( Expense ex) {

        ex.setDatetime(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));

        expenseRepo.save(ex);
    }

    //    --------------------- update the expenses ---------------------------------------------

    public void updateexpenses(int id,Expense ex) {

        Expense expense = expenseRepo.findById(id).orElseThrow(()->new ExpenseNotFoundException());

        expense.setCategory(ex.getCategory());
        expense.setAmount(ex.getAmount());
        expense.setDescription(ex.getDescription());
        expense.setDatetime(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));

        expenseRepo.save(expense);


    }

    //    ------------------------ delete the expenses ---------------------------------------


    public void deleteexpenses() {

        expenseRepo.deleteAll();

    }


    //    ------------------------ delete the expenses by id ---------------------------------------


    public void deleteById(int id) {

        expenseRepo.deleteById(id);
    }



    //    ----------------------------- summary ------------------------------------------------------


    public List<Expensesummary> summary(String year, String month) {

        return expenseRepo.findByYearAndMonth(Integer.parseInt(year),Integer.parseInt(month));


    }

}