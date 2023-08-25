package com.dzakirinmd.department;

import com.dzakirinmd.department.client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeClient employeeClient;

    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public FullDepartmentResponse getAllEmployeesInDepartment(Long departmentId) {
        var department = departmentRepository.findById(departmentId)
                .orElse(
                        Department.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()

                );

        // find all the employees from the employee micro-service
        var employees = employeeClient.findAllEmployeeByDepartment(departmentId);

        return FullDepartmentResponse.builder()
                .name(department.getName())
                .email(department.getEmail())
                .employees(employees)
                .build();
    }
}
