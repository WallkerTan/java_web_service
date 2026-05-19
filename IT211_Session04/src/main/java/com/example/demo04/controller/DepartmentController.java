package com.example.demo04.controller;

import com.example.demo04.model.dto.reponse.ApiDataRepose;
import com.example.demo04.model.entity.Department;
import com.example.demo04.service.DepartmentService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    // GET ALL
    @GetMapping
    public ResponseEntity<ApiDataRepose<?>> getDepartments() {

        return ResponseEntity.ok(new ApiDataRepose<>(true, "Lấy danh sách department thành công",
                departmentService.getDepartments(), HttpStatus.OK));
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiDataRepose<Department>> getDepartmentById(@PathVariable Long id) {

        return ResponseEntity.ok(new ApiDataRepose<>(true, "Lấy department thành công",
                departmentService.getDepartmentById(id), HttpStatus.OK));
    }

    // INSERT
    @PostMapping
    public ResponseEntity<ApiDataRepose<Department>> insertDepartment(
            @RequestBody Department department) {

        return new ResponseEntity<>(
                new ApiDataRepose<>(true, "Thêm department thành công",
                        departmentService.insertDepartment(department), HttpStatus.CREATED),
                HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiDataRepose<Department>> updateDepartment(@PathVariable Long id,
            @RequestBody Department department) {

        return ResponseEntity.ok(new ApiDataRepose<>(true, "Update department thành công",
                departmentService.updateDepartment(id, department), HttpStatus.OK));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataRepose<Department>> deleteDepartment(@PathVariable Long id) {

        return ResponseEntity.ok(new ApiDataRepose<>(true, "Xóa department thành công",
                departmentService.deleteDepartmentById(id), HttpStatus.OK));
    }
}
