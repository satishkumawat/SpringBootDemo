package com.springboot.demo.controller;

import com.springboot.demo.dto.EmployeeDTO;
import com.springboot.demo.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/get/by/id/{id}")
    public EmployeeDTO getEmployeesById(@PathVariable("id") Long employeeid){
        return employeeService.getEmployeeById(employeeid);
    }
    @GetMapping(path = "/get/all/employee")
    public List<EmployeeDTO>getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/save")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createNewEmployee(employeeDTO);
    }
    @DeleteMapping(path = "/delete/by/id/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }
}
