package dev.chococake.crud_project.service;

import dev.chococake.crud_project.dto.EmployeeDto;
import dev.chococake.crud_project.entity.Employee;
import dev.chococake.crud_project.exception.ResourceNotFoundException;
import dev.chococake.crud_project.mapper.EmployeeMapper;
import dev.chococake.crud_project.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + employeeID + " not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeID, EmployeeDto updatedemployeeDto) {
        Employee employee = employeeRepository.findById(employeeID).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + employeeID + " not found"));
        employee.setFirstName(updatedemployeeDto.getFirstName());
        employee.setLastName(updatedemployeeDto.getLastName());
        employee.setEmail(updatedemployeeDto.getEmail());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + employeeID + " not found"));
        employeeRepository.deleteById(employeeID);
    }


}
