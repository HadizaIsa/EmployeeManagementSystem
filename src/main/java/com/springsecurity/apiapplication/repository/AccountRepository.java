package com.springsecurity.apiapplication.repository;

import com.springsecurity.apiapplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String username);
}
