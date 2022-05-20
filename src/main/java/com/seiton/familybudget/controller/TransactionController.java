package com.seiton.familybudget.controller;

import com.seiton.familybudget.model.Transaction;
import com.seiton.familybudget.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/telegramm")
public class TransactionController {
    private TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable long id){
        return transactionService.getTransaction(id);
    }

    @PostMapping("/transaction/new")
    public long addTransaction(@RequestBody @Valid Transaction transaction){
        return transactionService.addTransaction(transaction);
    }


    @DeleteMapping("/transaction/{id}")
    public void deleteTransaction(@PathVariable long id){
        transactionService.deleteTransaction(id);
    }
    @PutMapping("/transaction/{id}")
    public void updateTransaction(@RequestBody @Valid Transaction transaction, @PathVariable long id){
        transactionService.updateTransaction(id, transaction);
    }
}
