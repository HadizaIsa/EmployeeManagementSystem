package com.springsecurity.apiapplication.domain.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class AddEmployeeRequest {
//    private Long id;
    private String firstName;

    private String lastName;

    private String userName;

}
