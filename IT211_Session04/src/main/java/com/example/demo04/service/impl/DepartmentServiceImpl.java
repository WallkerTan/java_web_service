package com.example.demo04.service.impl;

import com.example.demo04.repository.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo04.model.entity.Department;
import com.example.demo04.repository.DepartmentRepository;
import com.example.demo04.service.DepartmentService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department insertDepartment(Department department) {
        if (department != null) {
            departmentRepository.save(department);
            return department;
        }
        return null;
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department d = getDepartmentById(id);
        if (d != null) {
            d.setDepartName(department.getDepartName());
            d.setStatus(department.getStatus());
            departmentRepository.save(d);
            return d;
        }
        return null;
    }

    @Override
    public Department deleteDepartmentById(Long id) {
        Department d = getDepartmentById(id);
        if (d == null) {
            return null;
        }

        departmentRepository.delete(getDepartmentById(id));
        return d;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);

    }

}
