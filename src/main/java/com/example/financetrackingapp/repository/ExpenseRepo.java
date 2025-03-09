package com.example.financetrackingapp.repository;

import com.example.financetrackingapp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
}
