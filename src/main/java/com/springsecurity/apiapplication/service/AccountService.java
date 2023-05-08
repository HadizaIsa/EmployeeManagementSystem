package com.springsecurity.apiapplication.service;

import com.springsecurity.apiapplication.model.Account;
import com.springsecurity.apiapplication.model.Role;
import com.springsecurity.apiapplication.repository.AccountRepository;
import com.springsecurity.apiapplication.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    public Account createAccount(Account account){
        account.setPassword(encoder.encode(account.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);
        return accountRepository.save(account);

    }

    public Account findByUsername(String username){
        return accountRepository.findByUserName(username);
    }

    public List<Account> getAccounts(){
        return null;
    }
}
