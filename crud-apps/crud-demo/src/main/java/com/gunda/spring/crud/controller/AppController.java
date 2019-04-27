package com.gunda.spring.crud.controller;

import com.gunda.spring.crud.model.Employee;
import com.gunda.spring.crud.service.AppService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/app")
public class AppController {


    @Autowired
    private AppService appService;


    //CREATE
    @PostMapping("create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        log.info("createEmployee : STARTS");
        final var savedEmployee = appService.createEmployee(employee);
        log.info("createEmployee : ENDS");
        return ResponseEntity.ok(savedEmployee);
    }


    //CREATE MULTIPLE
    @PostMapping("createAll")
    public ResponseEntity<List<Employee>> createAllEmployees(@RequestBody List<Employee> employees) {
        log.info("createAllEmployees : STARTS");
        final var savedEmployees = appService.createEmployees(employees);
        log.info("createAllEmployees : ENDS");
        return ResponseEntity.ok(savedEmployees);

    }

    //UPDATE
    @PutMapping("update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @RequestParam Long empId) {
        log.info("updateEmployee : STARTS");
        Employee updatedEmployee = appService.updateEmployee(employee, empId);
        log.info("updateEmployee : ENDS");
        return ResponseEntity.ok(updatedEmployee);
    }

    //READ
    @GetMapping("getById")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam Long empId) {
        log.info("in getEmployeeById");
        return ResponseEntity.ok(appService.getEmployeeById(empId));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Employee>> getAllEmps() {
        log.info("in getAllEmps");
        return ResponseEntity.ok(appService.getAllEmployees());
    }


    //DELETE
    @DeleteMapping("deleteById")
    public ResponseEntity<String> deleteEmployeeById(@RequestParam Long empId) {
        log.info("in deleteEmployeeById.");
        appService.deleteEmployeeById(empId);
        return ResponseEntity.ok("Employee with id" + empId + " successfully deleted");
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<String> deleteAllEmployees() {
        log.info("in deleteEmployeeById.");
        appService.deleteAllEmployees();
        return ResponseEntity.ok("All Employees data got successfully deleted");
    }


}
