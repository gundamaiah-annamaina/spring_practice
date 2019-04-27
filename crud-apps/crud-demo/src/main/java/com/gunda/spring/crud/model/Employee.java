package com.gunda.spring.crud.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "EMPLOYEE_MASTER")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID", nullable = false)
    private Long id;

    @Column(name = "EMP_NAME", nullable = false)
    private String name;

    @Column(name = "EMP_SAL")
    private BigDecimal salary;

    @Column(name = "EMP_DEPT", nullable = false)
    private String department;


}
