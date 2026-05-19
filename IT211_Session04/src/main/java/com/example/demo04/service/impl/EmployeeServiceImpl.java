package com.example.demo04.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo04.model.entity.Employee;
import com.example.demo04.repository.EmployeeRepository;
import com.example.demo04.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        if(employee==null){
            return null;
        }
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updatEmployee(Long id, Employee employee) {
        Employee e = getEmployeeById(id);
        if(e!=null){
            e.setAddress(employee.getAddress());
            e.setBirthday(employee.getBirthday());
            e.setFullname(employee.getFullname());
            e.setGender(employee.getGender());
            employeeRepository.save(e);
            return e;
        }
        return null;
    }

    @Override
    public Employee deleteEmployeeById(Long id) {
        Employee e = getEmployeeById(id);
        if(e==null){
            return null;
        }
        employeeRepository.delete(getEmployeeById(id));
        return e;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> getEmployeeWithSorting(Integer page, Integer pageSize,String sortBy ,String oderBy) {
            Sort sort = null;
            sort = switch(sortBy){
                case "id" -> Sort.by("id");
                case "fullname" -> Sort.by("fullname");
                case "gender" -> Sort.by("gender");
                case "birthday" -> Sort.by("birthday");
                case "address" -> Sort.by("address");
                default -> Sort.by("id");
            };
            sort = switch(oderBy){
                case "asc" ->sort.ascending();
                case "desc" -> sort.descending();
                default -> sort.ascending();
            };
            
            Pageable pageable = PageRequest.of(page, pageSize,sort);
            return employeeRepository.findAll(pageable);

    }

    @Override
    public Page<Employee> findByFullnameContains(String fullname, Integer page, Integer pageSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByFullnameContains'");
    }
    
}
