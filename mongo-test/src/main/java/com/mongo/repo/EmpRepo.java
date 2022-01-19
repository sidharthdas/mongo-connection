package com.mongo.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongo.entity.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sidharthdas on 07/12/21.
 */
@Repository
public class EmpRepo {

    @Autowired
    private MongoClient mongoClient;

    public List< Employee > getAll () {
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection< Document > col = db.getCollection("employee");
        List< Employee > emp = new ArrayList<>();

        for (Document d : col.find()) {
            Employee e1 = new Employee(d.get("_id").toString(), d.getString("name"), d.getString("email"), d.getString("address"));
            emp.add(e1);
        }

        return emp;
    }

    public String addEmployee ( Employee emp ) {
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection< Document > col = db.getCollection("employee");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.append("name", emp.getName()).append("email", emp.getEmail());

        FindIterable<Document> d=  col.find(searchQuery);
       if(d.iterator().hasNext()){
           return "Aready exit";
       }
        Document c1 = new Document();
        c1.append("name", emp.getName());
        c1.append("email", emp.getEmail());
        c1.append("address", emp.getAddress());
        c1.append("address2", "India");

        String response;
        try {
            col.insertOne(c1);
            response = "Successfully Added.";
        } catch (Exception ee) {
            ee.printStackTrace();
            response = "Not able to added.";
        }

        return response;
    }

    public String updateEmp ( Employee emp ) {
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection< Document > col = db.getCollection("employee");
        Document c1 = new Document();
        c1.append("name", emp.getName());
        c1.append("email", emp.getEmail());
        c1.append("address", emp.getAddress());
        c1.append("address2", "London");

        String response;
        try {
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("$set", new BasicDBObject().append("email", emp.getEmail()));
            BasicDBObject searchQuery = new BasicDBObject().append("name", "Sagar").append("email", "sagardas@gmail.com");
            col.updateOne(searchQuery, newDocument);
            response = "Successfully updated.";
        } catch (Exception ee) {
            ee.printStackTrace();
            response = "Not able to added.";
        }

        return response;

    }


    public String updateOrInsert ( Employee emp ) {

        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection< Document > collection = db.getCollection("employee");
        Document c1 = new Document();
        c1.append("name", emp.getName());
        c1.append("email", emp.getEmail());
        c1.append("address", emp.getAddress());

        String jsonString;
        ObjectMapper mapper = new ObjectMapper();
        String response;
        try {
            jsonString = mapper.writeValueAsString(emp);
            //System.out.println(jsonString);
            BasicDBObject searchQuery = new BasicDBObject().append("_id", "450000000000");
            BasicDBObject doc = BasicDBObject.parse(jsonString);
            Bson newDocument = new Document("$set", doc);
            //System.out.println(newDocument.toString());
            UpdateOptions option = new UpdateOptions().upsert(true);
            collection.updateOne(searchQuery, newDocument, option);
            response = "Operation successful";
        } catch (Exception ee) {
            response = "Not added or updated";
            ee.printStackTrace();
        }

        return response;
    }

}
