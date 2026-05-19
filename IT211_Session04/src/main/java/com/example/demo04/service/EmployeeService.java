package com.example.demo04.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.example.demo04.model.entity.Employee;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee insertEmployee(Employee employee);
    Employee updatEmployee(Long id, Employee employee);
    Employee deleteEmployeeById(Long id);
    Employee getEmployeeById(Long id);
    Page<Employee> getEmployeeWithSorting(Integer page,Integer pageSize, String sortBy,String oderBy);
    Page<Employee> findByFullnameContains(String fullname, Integer page,Integer pageSize);
}
