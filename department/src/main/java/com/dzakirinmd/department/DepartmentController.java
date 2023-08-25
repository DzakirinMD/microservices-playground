package com.dzakirinmd.department;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @GetMapping("/with-employees/{department-id}")
    public ResponseEntity<FullDepartmentResponse> getAllEmployeesInDepartment(@PathVariable("department-id") Long departmentId) {
        return ResponseEntity.ok(departmentService.getAllEmployeesInDepartment(departmentId));
    }
}
