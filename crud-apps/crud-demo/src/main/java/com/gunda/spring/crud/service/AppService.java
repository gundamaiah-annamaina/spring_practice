package com.gunda.spring.crud.service;

import com.gunda.spring.crud.dao.EmployeeRepository;
import com.gunda.spring.crud.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class AppService {


    @Autowired
    private EmployeeRepository employeeRepository;


    //CREATE
    public Employee createEmployee(Employee employee) {
        log.info("createEmployee : STARTS");

        Employee savedEmployee = employeeRepository.save(employee);
        log.info("createEmployee : ENDS");
        return savedEmployee;
    }

    public List<Employee> createEmployees(List<Employee> employees) {
        log.info("createEmployees : STARTS");
        List<Employee> savedEmployees = employeeRepository.saveAll(employees);

        log.info("createEmployees : ENDS");
        return employees;
    }

    //UPDATE
    public Employee updateEmployee(Employee employee, Long empId) {
        log.info("updateEmployee : STARTS");
        Employee existingEmployee = getEmployeeById(empId);
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDepartment(employee.getDepartment());


        employeeRepository.save(existingEmployee);
        log.info("updateEmployee : ENDS");

        return existingEmployee;
    }

    //READ
    public Employee getEmployeeById(Long empId) {
        log.info("in getEmployeeById");
        Employee employee = employeeRepository.findById(empId).get();
        return employee;
    }

    //READ
    public List<Employee> getAllEmployees() {
        log.info("in getAllEmployees");
        return employeeRepository.findAll();
    }

    //DELETE
    public void deleteEmployeeById(Long id) {
        log.info("in deleteEmployeeById");
        employeeRepository.deleteById(id);
    }


    public void deleteAllEmployees() {
        log.info("in deleteAllEmployees");
        employeeRepository.deleteAll();
    }


}
