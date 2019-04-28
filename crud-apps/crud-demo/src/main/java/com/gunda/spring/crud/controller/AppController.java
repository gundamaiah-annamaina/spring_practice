package com.gunda.spring.crud.controller;

import com.gunda.spring.crud.model.Employee;
import com.gunda.spring.crud.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/app")
@Api(value = "Employee API")
public class AppController {


    @Autowired
    private AppService appService;


    //CREATE
    @ApiOperation(value = "Create Employee", notes = "To create Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created Employee")
    })
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        log.info("createEmployee : STARTS");
        final var savedEmployee = appService.createEmployee(employee);
        log.info("createEmployee : ENDS");
        return ResponseEntity.ok(savedEmployee);
    }


    //CREATE MULTIPLE
    @ApiOperation(value = "Create Employees", notes = "To create Employees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created multiple Employees")
    })
    @PostMapping("/createAll")
    public ResponseEntity<List<Employee>> createAllEmployees(@RequestBody List<Employee> employees) {
        log.info("createAllEmployees : STARTS");
        final var savedEmployees = appService.createEmployees(employees);
        log.info("createAllEmployees : ENDS");
        return ResponseEntity.ok(savedEmployees);

    }

    //UPDATE
    @ApiOperation(value = "Update Employees", notes = "To update Employees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated  Employee")
    })
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @RequestParam Long empId) {
        log.info("updateEmployee : STARTS");
        Employee updatedEmployee = appService.updateEmployee(employee, empId);
        log.info("updateEmployee : ENDS");
        return ResponseEntity.ok(updatedEmployee);
    }

    //READ
    @ApiOperation(value = "Get Employee", notes = "To get Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get  Employee data")
    })
    @GetMapping("/getById")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam Long empId) {
        log.info("in getEmployeeById");
        return ResponseEntity.ok(appService.getEmployeeById(empId));
    }

    @ApiOperation(value = "Get All  Employees", notes = "To get all Employees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get  all Employees data")
    })
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmps() {
        log.info("in getAllEmps");
        return ResponseEntity.ok(appService.getAllEmployees());
    }


    //DELETE
    @ApiOperation(value = "Delete Employee", notes = "To delete Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted  Employee data")
    })
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteEmployeeById(@RequestParam Long empId) {
        log.info("in deleteEmployeeById.");
        appService.deleteEmployeeById(empId);
        return ResponseEntity.ok("Employee with id" + empId + " successfully deleted");
    }

    @ApiOperation(value = "Delete All Employees", notes = "To delete all  Employees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted  all Employees data")
    })
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllEmployees() {
        log.info("in deleteEmployeeById.");
        appService.deleteAllEmployees();
        return ResponseEntity.ok("All Employees data got successfully deleted");
    }


}
