package com.example.financetrackingapp.service;

import com.example.financetrackingapp.model.Income;
import com.example.financetrackingapp.model.Expense;
import com.example.financetrackingapp.repository.IncomeRepo;
import com.example.financetrackingapp.repository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {
    private final IncomeRepo incomeRepository;
    private final ExpenseRepo expenseRepository;

    public FinancialService(IncomeRepo incomeRepository, ExpenseRepo expenseRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    // Add Income
    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    // Add Expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Delete Income
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }

    // Delete Expense
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Update Income
    public Income updateIncome(Long id, Income newIncome) {
        return incomeRepository.findById(id).map(income -> {
            income.setSource(newIncome.getSource());
            income.setAmount(newIncome.getAmount());
            income.setDate(newIncome.getDate());
            return incomeRepository.save(income);
        }).orElse(null);
    }

    // Update Expense
    public Expense updateExpense(Long id, Expense newExpense) {
        return expenseRepository.findById(id).map(expense -> {
            expense.setCategory(newExpense.getCategory());
            expense.setAmount(newExpense.getAmount());
            expense.setDate(newExpense.getDate());
            return expenseRepository.save(expense);
        }).orElse(null);
    }

    // Get All Transactions
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}

