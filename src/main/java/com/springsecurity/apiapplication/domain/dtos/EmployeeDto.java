package com.springsecurity.apiapplication.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class EmployeeDto {

    private String firstName;

    private String lastName;

    private String userName;

}
