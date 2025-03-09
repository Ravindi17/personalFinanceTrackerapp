package com.example.financetrackingapp.controller;

import com.example.financetrackingapp.service.FinancialService;
import com.example.financetrackingapp.model.Income;
import com.example.financetrackingapp.model.Expense;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finance")
public class FinancialController {
    private final FinancialService financeService;

    public FinancialController(FinancialService financeService) {
        this.financeService = financeService;
    }

    @PostMapping("/income")
    public Income addIncome(@RequestBody Income income) {
        return financeService.addIncome(income);
    }

    @PostMapping("/expense")
    public Expense addExpense(@RequestBody Expense expense) {
        return financeService.addExpense(expense);
    }

    @DeleteMapping("/income/{id}")
    public void deleteIncome(@PathVariable Long id) {
        financeService.deleteIncome(id);
    }

    @DeleteMapping("/expense/{id}")
    public void deleteExpense(@PathVariable Long id) {
        financeService.deleteExpense(id);
    }

    @PutMapping("/income/{id}")
    public Income updateIncome(@PathVariable Long id, @RequestBody Income income) {
        return financeService.updateIncome(id, income);
    }

    @PutMapping("/expense/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return financeService.updateExpense(id, expense);
    }

    @GetMapping("/income")
    public List<Income> getAllIncome() {
        return financeService.getAllIncome();
    }

    @GetMapping("/expense")
    public List<Expense> getAllExpenses() {
        return financeService.getAllExpenses();
    }
}
