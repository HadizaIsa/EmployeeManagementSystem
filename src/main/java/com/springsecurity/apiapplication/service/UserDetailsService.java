package com.springsecurity.apiapplication.service;

import com.springsecurity.apiapplication.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsService {

    private final AccountService accountService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);

        if(account == null){
            throw new UsernameNotFoundException("user" + username + "not found");
        }

        if(account.getRoles() == null || account.getRoles().isEmpty()){
            throw new RuntimeException("user has no roles");
        }

        Collection<GrantedAuthority> authorities = account.getRoles().stream().map(
            role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());

        return new User(account.getUsername(), account.getPassword(), account.isEnabled(),
            !account.isExpired(), !account.isCredentialsexpired(), !account.isLocked(), authorities);
    }

}
