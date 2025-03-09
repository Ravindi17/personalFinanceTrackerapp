package com.example.financetrackingapp.repository;

import com.example.financetrackingapp.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepo extends JpaRepository<Income, Long> {
}
