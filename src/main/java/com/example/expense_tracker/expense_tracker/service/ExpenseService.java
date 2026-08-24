package com.example.expense_tracker.expense_tracker.service;


import com.example.expense_tracker.expense_tracker.dto.ExpenseDTO;
import com.example.expense_tracker.expense_tracker.exception.ExpenseNotFoundException;
import com.example.expense_tracker.expense_tracker.model.Expense;
import com.example.expense_tracker.expense_tracker.repository.ExpenseRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    ExpenseRepo expenseRepo;

    ExpenseService(ExpenseRepo expenseRepo){

        this.expenseRepo=expenseRepo;
    }


    public List<ExpenseDTO> getallexpenses() {


        List<Expense> expenses=expenseRepo.findAll();

        List<ExpenseDTO> results = new ArrayList<>();

        for(Expense ex:expenses){

            ExpenseDTO dto = new ExpenseDTO();

            dto.setCategory(ex.getCategory());
            dto.setAmount(ex.getAmount());
            dto.setDescription(ex.getDescription());
            dto.setDatetime(ex.getDatetime());

            results.add(dto);
        }

        return results;
    }

    public List<ExpenseDTO> getexpensesbyId(int id) {

        List<Expense> expenses=expenseRepo.findById(id).orElse(
                new ExpenseNotFoundException()
        );

        List<ExpenseDTO> results = new ArrayList<>();

        for(Expense ex:expenses){

            ExpenseDTO dto = new ExpenseDTO();

            dto.setCategory(ex.getCategory());
            dto.setAmount(ex.getAmount());
            dto.setDescription(ex.getDescription());
            dto.setDatetime(ex.getDatetime());

            results.add(dto);
        }

        return results;
    }



    }


//    private final ExpenseRepo expenseRepo;
//
//    public ExpenseService(ExpenseRepo expenseRepo) {
//        this.expenseRepo = expenseRepo;
//    }
//
//
//    // ==================== GET ALL EXPENSES ====================
//    // Used by Home Page when loading all expenses.
//    // Example: GET /expenses
//    public List<ExpenseDTO> getAllExpense() {
//
//        List<Expense> expenses = expenseRepo.findAll();
//
//        List<ExpenseDTO> results = new ArrayList<>();
//
//        for (Expense ex : expenses) {
//
//            ExpenseDTO dto = new ExpenseDTO();
//
//            dto.setCategory(ex.getCategory());
//            dto.setAmount(ex.getAmount());
//            dto.setPayment_method(ex.getPayment_method());
//            dto.setDescription(ex.getDescription());
//            dto.setDatetime(ex.getDatetime());
//
//            results.add(dto);
//        }
//
//        return results;
//    }
//
//
//    // ==================== ADD EXPENSE ====================
//    // Used when the user presses Save on the Add Expense page.
//    // Example: POST /expenses
//    public void postmyexpenses(ExpenseDTO expenseDTO) {
//
//        Expense ex = new Expense();
//
//        ex.setCategory(expenseDTO.getCategory());
//        ex.setAmount(expenseDTO.getAmount());
//        ex.setPayment_method(expenseDTO.getPayment_method());
//        ex.setDescription(expenseDTO.getDescription());
//        ex.setDatetime(expenseDTO.getDatetime());
//
//        expenseRepo.save(ex);
//    }
//
//
//    // ==================== DELETE ONE EXPENSE ====================
//    // Used when the user deletes a particular expense.
//    // Example: DELETE /expenses/{id}
//    public void deletemyexpenses(int id) {
//
//        expenseRepo.deleteById(id);
//    }
//
//
//    // ==================== SEARCH EXPENSES ====================
//    // Used by the Home Page search bar.
//    // Searches category, amount, payment method, description and date.
//    // Example: GET /expenses/search?query=food
//    public List<ExpenseDTO> searchExpenses(String query) {
//
//        List<Expense> expenses = expenseRepo.searchExpenses(query);
//
//        List<ExpenseDTO> results = new ArrayList<>();
//
//        for (Expense ex : expenses) {
//
//            ExpenseDTO dto = new ExpenseDTO();
//
//            dto.setCategory(ex.getCategory());
//            dto.setAmount(ex.getAmount());
//            dto.setPayment_method(ex.getPayment_method());
//            dto.setDescription(ex.getDescription());
//            dto.setDatetime(ex.getDatetime());
//
//            results.add(dto);
//        }
//
//        return results;
//    }
//
//
//    // ==================== UPDATE EXPENSE ====================
//    // Used when editing an existing expense.
//    // Example: PUT /expenses/{id}
//    public void updateexpenses(int id, ExpenseDTO expenseDTO) {
//
//        Expense ex = expenseRepo.findById(id)
//                .orElseThrow(() ->
//                        new ExpenseNotFoundException(
//                                "Expense not found with id: " + id
//                        )
//                );
//
//        ex.setCategory(expenseDTO.getCategory());
//        ex.setAmount(expenseDTO.getAmount());
//        ex.setPayment_method(expenseDTO.getPayment_method());
//        ex.setDescription(expenseDTO.getDescription());
//        ex.setDatetime(expenseDTO.getDatetime());
//
//        expenseRepo.save(ex);
//    }
//
//
//    // ==================== GET ONE EXPENSE ====================
//    // Used when you need the details of one expense by ID.
//    // Example: GET /expenses/{id}
//    public ExpenseDTO getexpensebyid(int id) {
//
//        Expense ex = expenseRepo.findById(id)
//                .orElseThrow(() ->
//                        new ExpenseNotFoundException(
//                                "Expense not found with id: " + id
//                        )
//                );
//
//        ExpenseDTO dto = new ExpenseDTO();
//
//        dto.setCategory(ex.getCategory());
//        dto.setAmount(ex.getAmount());
//        dto.setPayment_method(ex.getPayment_method());
//        dto.setDescription(ex.getDescription());
//        dto.setDatetime(ex.getDatetime());
//
//        return dto;
//    }
//
//
//    // ==================== DELETE ALL EXPENSES ====================
//    // Used only if you have a "Delete All" feature.
//    // Example: DELETE /expenses
//    public void deleteall() {
//
//        expenseRepo.deleteAll();
//    }
}