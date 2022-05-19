package com.seiton.familybudget.controller;

import com.seiton.familybudget.model.Account;
import com.seiton.familybudget.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/telegramm")
public class AccountController {

    private AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable long id){
        return accountService.getAccount(id);
    }

    @PostMapping("/account/new")
    public long postAccount(@Valid @RequestBody Account account){
        return accountService.addAccount(account);
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable long id){
        accountService.deleteAccount(id);
    }


    @PutMapping("/account/{id}")
    public void updateAccount(@Valid @RequestBody Account account, @PathVariable long id){
        accountService.updateAccount(account, id);
    }

}
