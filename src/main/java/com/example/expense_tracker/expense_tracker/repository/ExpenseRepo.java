package com.example.expense_tracker.expense_tracker.repository;

import com.example.expense_tracker.expense_tracker.dto.Expensesummary;
import com.example.expense_tracker.expense_tracker.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {

    @Query(value = """
    SELECT *
    FROM expense
    WHERE LOWER(category) LIKE LOWER(CONCAT('%', :query, '%'))
       OR LOWER(description) LIKE LOWER(CONCAT('%', :query, '%'))
       OR CAST(amount AS TEXT) LIKE CONCAT('%', :query, '%')
    """, nativeQuery = true)
    Page<Expense> searchExpenses(
            @Param("query") String query,
            Pageable pageable
    );

    @Query(value = """
        SELECT category as category, SUM(amount) as amount
        FROM expense
        WHERE EXTRACT(YEAR FROM datetime) = :year
          AND EXTRACT(MONTH FROM datetime) = :month
        GROUP BY category
        """, nativeQuery = true)
    List<Expensesummary> findByYearAndMonth(
            @Param("year") int year,
            @Param("month") int month);



}