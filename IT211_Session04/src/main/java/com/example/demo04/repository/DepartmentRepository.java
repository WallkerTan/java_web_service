package com.example.demo04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo04.model.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    
}
