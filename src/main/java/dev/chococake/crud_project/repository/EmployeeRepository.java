package dev.chococake.crud_project.repository;

import dev.chococake.crud_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
