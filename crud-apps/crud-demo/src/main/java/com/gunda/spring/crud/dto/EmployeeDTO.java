package com.gunda.spring.crud.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeDTO {


    private Long id;
    private String name;
    private BigDecimal salary;
    private String department;
}
