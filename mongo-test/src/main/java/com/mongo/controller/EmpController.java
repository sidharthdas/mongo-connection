package com.mongo.controller;

import com.mongo.entity.Employee;
import com.mongo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sidharthdas on 07/12/21.
 */
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/all-emp")
    public List< Employee> allEmp(){
        return empService.getAllEmp();
    }

    @PostMapping("/add-emp")
    public String addEmp(@RequestBody Employee emp){
        return empService.addEmp(emp);
    }

    @PutMapping("/update-emp")
    public String updateEmp(@RequestBody  Employee emp){
        return empService.updateEmp(emp);
    }

    @PutMapping("/upsert-emp")
    public String upsertEmp(@RequestBody  Employee emp){
        return empService.updateOrInsert(emp);
    }
}
