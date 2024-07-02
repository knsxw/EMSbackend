package dev.chococake.crud_project.service;

import dev.chococake.crud_project.dto.EmployeeDto;
import dev.chococake.crud_project.entity.Employee;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeID);
}
