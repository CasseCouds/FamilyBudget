package com.seiton.familybudget.repository;

import com.seiton.familybudget.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
