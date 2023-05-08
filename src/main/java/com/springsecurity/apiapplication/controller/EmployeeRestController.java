package com.springsecurity.apiapplication.controller;

import com.springsecurity.apiapplication.domain.dtos.EmployeeDto;
import com.springsecurity.apiapplication.domain.mappers.EmployeeDtoMapper;
import com.springsecurity.apiapplication.domain.requests.AddEmployeeRequest;
import com.springsecurity.apiapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    private final EmployeeDtoMapper employeeDtoMapper;

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody AddEmployeeRequest request){
        return new ResponseEntity<>(employeeDtoMapper.mapToDto(employeeService.addEmployee(request)),
            HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(
            employeeDtoMapper.mapToDto(employeeService.findById(id))
        );

    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(
            employeeDtoMapper.mapToDtos(employeeService.getAllEmployees())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody AddEmployeeRequest request){
        return ResponseEntity.ok(
            employeeDtoMapper.mapToDto(employeeService.updateEmployee(request))
        );
    }

    @DeleteMapping
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);

        return new ResponseEntity<>(
            HttpStatus.NO_CONTENT
        );
    }

}
