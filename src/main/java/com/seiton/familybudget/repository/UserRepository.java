package com.seiton.familybudget.repository;

import com.seiton.familybudget.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {
}
