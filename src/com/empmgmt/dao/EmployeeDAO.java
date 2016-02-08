package com.empmgmt.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.empmgmt.converter.EmployeeConverter;
import com.empmgmt.model.Employee;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
 
/**
 * DAO class for different MongoDB operations for the Employee module
 * @author seema
 *
 */
public class EmployeeDAO {
 
    private MongoCollection col;
 
    /**
     * DAO class constructor
     * @param mongo
     */
    public EmployeeDAO(MongoClient mongo) {
    	MongoDatabase db  = mongo.getDatabase("test");
        this.col = (MongoCollection) db.getCollection("employee");
    }
 
     /**
     * Fetch all the employees from mongodb
     * @return
     */
    public JSONArray  readAllEmployees() {
        MongoCursor cursor = this.col.find().iterator();
        
        JSONObject json      = new JSONObject();
        JSONArray  employees = new JSONArray();
        JSONObject employee;
       
        while (cursor.hasNext()) {
        
        	json = EmployeeConverter.toJSONEmployee((Document)cursor.next());
        	employees.add(json);
        }
        return employees;
    }
}