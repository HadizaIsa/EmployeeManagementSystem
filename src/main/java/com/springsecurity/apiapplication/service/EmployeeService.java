package com.springsecurity.apiapplication.service;

import com.springsecurity.apiapplication.domain.requests.AddEmployeeRequest;
import com.springsecurity.apiapplication.model.Employee;
import com.springsecurity.apiapplication.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(AddEmployeeRequest employee){
        return buildEmployee(employee);
    }

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
        // when you're trying to get all record remember to paginate

    }

    @Transactional
    public Employee findById(Long id){
        return employeeRepository.findById(id)
             .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public Employee updateEmployee(AddEmployeeRequest employee){
        return buildEmployee(employee);
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    private Employee buildEmployee(AddEmployeeRequest request){
        return Employee.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .userName(request.getUserName())
            .build();
    }
}
