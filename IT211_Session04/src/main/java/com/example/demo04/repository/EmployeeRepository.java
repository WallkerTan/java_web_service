package com.example.demo04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo04.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
