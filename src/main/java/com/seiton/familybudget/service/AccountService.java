package com.seiton.familybudget.service;

import com.seiton.familybudget.exception.AccountNotFoundException;
import com.seiton.familybudget.model.Account;
import com.seiton.familybudget.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(long id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException()
        );
    }

    public long addAccount(Account account) {
        return accountRepository.save(account).getId();
    }

    public void deleteAccount(long id) {
        this.accountRepository.deleteById(id);
    }

    public void updateAccount(Account account, long id) {
        if (accountRepository.existsById(id)) {
            account.setId(id);
            accountRepository.save(account);
        } else {
            throw new AccountNotFoundException();
        }
    }
}
