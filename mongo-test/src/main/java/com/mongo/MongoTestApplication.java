package com.mongo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongo.entity.Employee;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MongoTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongoTestApplication.class, args);
	}
	
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient("127.0.0.1", 27017);
	}

	@Override
	public void run ( String... args ) throws Exception {

		Object o = Arrays.asList(new Employee("1","e1","sxsa","dsds"),
				new Employee("2","e1","sxsa","dsds"),
				new Employee("3","e1","sxsa","dsds"),
				new Employee("4","e1","sxsa","dsds"),
				new Employee("5","e1","sxsa","dsds"));
		ObjectMapper mapper = new ObjectMapper();
		List<Object> objArr = new ObjectMapper().readValue( mapper.writeValueAsString(o), List.class);

		System.out.println(mapper.writeValueAsString(objArr.get(1)));

	}
	
	

	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		MongoClient mongoClient = mongoClient();
		System.out.println("Sidharth");
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> empCol = database.getCollection("employee");
		
		*//*Document emp1 = new Document();
		emp1.append("name", "Sidharth");
		emp1.append("address", "Bangalore");
		emp1.append("email", "sid@gmail.com1114444");
		
		empCol.insertOne(emp1);*//*
		
	
		
	}*/

}
