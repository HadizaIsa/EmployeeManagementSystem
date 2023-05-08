package com.springsecurity.apiapplication.controller;

import com.springsecurity.apiapplication.domain.dtos.AccountDto;
import com.springsecurity.apiapplication.domain.mappers.AccountDtoMapper;
import com.springsecurity.apiapplication.domain.mappers.EmployeeDtoMapper;
import com.springsecurity.apiapplication.domain.requests.AddEmployeeRequest;
import com.springsecurity.apiapplication.service.AccountService;
import com.springsecurity.apiapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountRestController {

    private AccountService accountService;

    private EmployeeService employeeService;

    private EmployeeDtoMapper employeeDtoMapper;

    public ResponseEntity<AccountDto> createAccount(@RequestBody AddEmployeeRequest request){
        return new ResponseEntity<>(AccountDtoMapper.mapToDto(
            employeeService.addEmployee(request)), HttpStatus.CREATED);
    }

}
