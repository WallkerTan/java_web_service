package com.example.demo04.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo04.model.dto.reponse.ApiDataRepose;
import com.example.demo04.model.entity.Employee;
import com.example.demo04.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/e/Employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Value("${pageSize}")
    private int pageSize;

    // lấy all
    @GetMapping
    public ResponseEntity<ApiDataRepose<List<Employee>>> getEmployee() {
        return new ResponseEntity<>(new ApiDataRepose<>(true, "lấy data empoyees thành công",
                employeeService.getEmployees(), HttpStatus.OK), HttpStatus.OK);
    }

    // lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiDataRepose<Employee>> getEmployeeById(
            @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(
                new ApiDataRepose<>(true, "lấy data empoyees " + id + " thành công",
                        employeeService.getEmployeeById(id), HttpStatus.OK),
                HttpStatus.OK);
    }


    // thêm
    @PostMapping
    public ResponseEntity<ApiDataRepose<Employee>> insertEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(new ApiDataRepose<>(true, "thêm mới thành công",
                employeeService.insertEmployee(employee), HttpStatus.OK), HttpStatus.OK);
    }

    // sửa
    @PutMapping("/{id}")
    public ResponseEntity<ApiDataRepose<Employee>> updateEmployee(@PathVariable Long id,
            @RequestBody Employee employee) {

        return new ResponseEntity<>(new ApiDataRepose<>(true, "Update employee thành công",
                employeeService.updatEmployee(id, employee), HttpStatus.OK), HttpStatus.OK);
    }

    // xóa
    public ResponseEntity<ApiDataRepose<Employee>> deleteEmployee(@PathVariable Long id) {

        return new ResponseEntity<>(new ApiDataRepose<>(true, "delete employee thành công",
                employeeService.deleteEmployeeById(id), HttpStatus.OK), HttpStatus.OK);
    }

    // phân trang
    @GetMapping("/sort")
    public ResponseEntity<ApiDataRepose<Page<Employee>>> getEmployeeWithSorting(

            @RequestParam(defaultValue = "0") Integer page,

            @RequestParam(defaultValue = "5") Integer pageSize,

            @RequestParam(defaultValue = "id") String sortBy,

            @RequestParam(defaultValue = "asc") String orderBy) {

        return ResponseEntity.ok(new ApiDataRepose<>(true, "Lấy danh sách employee thành công",
                employeeService.getEmployeeWithSorting(page, pageSize, sortBy, orderBy),
                HttpStatus.OK));
    }
}
