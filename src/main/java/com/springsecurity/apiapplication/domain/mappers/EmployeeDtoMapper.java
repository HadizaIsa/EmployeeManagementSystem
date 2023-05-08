package com.springsecurity.apiapplication.domain.mappers;

import com.springsecurity.apiapplication.domain.dtos.EmployeeDto;
import com.springsecurity.apiapplication.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class EmployeeDtoMapper implements EntityMapper<Employee, EmployeeDto>{

    @Override
    public List<EmployeeDto> mapToDtos(List<Employee> employees) {
        return employees
            .stream()
            .map(this::mapToDto)
            .collect(toList());
    }

    @Override
    public List<Employee> mapToEntites(List<EmployeeDto> employeeDtos) {
        return employeeDtos
            .stream()
            .map(this::mapToEntity)
            .collect(toList());
    }

    @Override
    public EmployeeDto mapToDto(Employee employee) {
        if(employee == null) {
            return null;
        }
        return EmployeeDto.builder()
            .firstName(employee.getFirstName())
            .lastName(employee.getLastName())
            .userName(employee.getUserName())
            .build();
    }

    @Override
    public Employee mapToEntity(EmployeeDto employeeDto) {
        if(employeeDto == null) {
            return null;
        }
        return Employee.builder()
            .firstName(employeeDto.getFirstName())
            .lastName(employeeDto.getLastName())
            .userName(employeeDto.getUserName())
            .build();
    }
}