package com.seiton.familybudget.service;

import com.seiton.familybudget.exception.TransactionNotFoundException;
import com.seiton.familybudget.model.Transaction;
import com.seiton.familybudget.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction getTransaction(long id){
        return transactionRepository.findById(id).orElseThrow(
                () -> new TransactionNotFoundException()
        );
    }

    public long addTransaction(Transaction transaction){
        return transactionRepository.save(transaction).getId();
    }

    public void deleteTransaction(long id){
        transactionRepository.deleteById(id);
    }

    public void updateTransaction(long id, Transaction transaction){
        if (transactionRepository.existsById(id)){
            transaction.setId(id);
            transactionRepository.save(transaction);
        } else {
            throw new TransactionNotFoundException();
        }
    }
}
