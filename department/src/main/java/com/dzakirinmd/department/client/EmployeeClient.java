package com.dzakirinmd.department.client;

import com.dzakirinmd.department.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// feign is used for http call
@FeignClient(name ="employee-service", url = "${application.config.employees-url}")
public interface EmployeeClient {

    @GetMapping("/deparment/{department-id}")
    List<Employee> findAllEmployeeByDepartment(@PathVariable("department-id") Long departmentId);
}
