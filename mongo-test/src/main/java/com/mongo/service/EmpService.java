package com.mongo.service;

import com.mongo.entity.Employee;
import com.mongo.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sidharthdas on 07/12/21.
 */
@Service
public class EmpService {

    @Autowired
    private EmpRepo empRepo;

    public List<Employee> getAllEmp(){
        return empRepo.getAll();
    }

    public String addEmp(Employee emp){
        return empRepo.addEmployee(emp);
    }

    public String updateEmp(Employee emp){
        return empRepo.updateEmp(emp);
    }

    public String updateOrInsert(Employee emp){
        return empRepo.updateOrInsert(emp);
    }

}
