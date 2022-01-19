package com.mongo.route;

import com.mongo.entity.Employee;
import com.mongo.process.EmployeeProcess;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 * @author sidharthdas on 07/12/21.
 */
//@Component
public class EmployeeRoute extends RouteBuilder {

    /*private EmployeeProcess employeeProcess;

    public EmployeeRoute ( @Autowired EmployeeProcess employeeProcess ) {
        this.employeeProcess = employeeProcess;
    }*/

    @Override
    public void configure () throws Exception {


       /* restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.auto);

        rest().
                consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
                .post("/add-new-employee").type(Employee.class).to("direct:save-emp-data");*/

     /*   from("direct:save-emp-data").log("request comming");
              //  .process(new EmployeeProcess());*/

     /*   from("rest:post:add-new-employee").
                process(new EmployeeProcess());*/


        from("rest:post:add-new-employee").log("hellow");
    }
}
