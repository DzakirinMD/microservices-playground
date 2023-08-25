package com.dzakirinmd.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSequence")
    @SequenceGenerator(name = "employeeSequence", sequenceName = "employee_id_seq")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Long departmentId;
}
