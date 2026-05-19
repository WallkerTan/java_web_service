package com.example.demo04.service;

import java.util.List;
import com.example.demo04.model.entity.Department;

public interface DepartmentService {
    List<Department> getDepartments();
    Department insertDepartment(Department department);
    Department updateDepartment(Long id,Department department);
    Department deleteDepartmentById(Long id);
    Department getDepartmentById(Long id);
}
