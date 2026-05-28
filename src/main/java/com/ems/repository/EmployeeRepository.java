package com.ems.repository;
import java.util.List;
import com.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstNameContainingIgnoreCase(String keyword);
}