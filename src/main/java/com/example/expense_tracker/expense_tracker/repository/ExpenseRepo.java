package com.example.expense_tracker.expense_tracker.repository;

import com.example.expense_tracker.expense_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {



}