package dev.chococake.crud_project.service;

import dev.chococake.crud_project.dto.EmployeeDto;
import dev.chococake.crud_project.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeID);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeID, EmployeeDto updatedemployeeDto);

    void deleteEmployee(Long employeeID);
}
