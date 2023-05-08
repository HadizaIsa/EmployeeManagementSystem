package com.springsecurity.apiapplication.domain.dtos;

import lombok.Builder;

@Builder(toBuilder = true)
public class AccountDto {
    private String username;

    private String password;

}
