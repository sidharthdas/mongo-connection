package com.mongo.process;

import com.mongo.entity.Employee;
import com.mongo.service.EmpService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sidharthdas on 07/12/21.
 */
//@Component
public class EmployeeProcess implements Processor {
    @Autowired
    private EmpService empService;
    @Override
    public void process ( Exchange exchange ) throws Exception {
        Employee emp = exchange.getMessage().getBody(Employee.class);
        String res = empService.addEmp(emp);


    }
}
