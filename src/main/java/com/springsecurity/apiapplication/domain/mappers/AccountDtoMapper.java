package com.springsecurity.apiapplication.domain.mappers;

import com.springsecurity.apiapplication.domain.dtos.AccountDto;
import com.springsecurity.apiapplication.model.Account;
import com.springsecurity.apiapplication.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountDtoMapper implements EntityMapper<Account, AccountDto> {

    @Override
    public List<AccountDto> mapToDtos(List<Account> entities) {
        return null;
    }

    @Override
    public List<Account> mapToEntites(List<AccountDto> dtos) {
        return null;
    }

    @Override
    public AccountDto mapToDto(Account account) {
        if(account == null) {
            return null;
        }
        return AccountDto.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .build();
    }

    @Override
    public Account mapToEntity(AccountDto dto) {
        return null;
    }
}
