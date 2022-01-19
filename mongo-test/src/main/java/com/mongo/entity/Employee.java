package com.mongo.entity;

/**
 * @author sidharthdas on 07/12/21.
 */
public class Employee {
    //private  String _id;
    private String name;
    private String email;
    private String address;

    public Employee ( String _id, String name, String email, String address ) {
        //this._id = _id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

/*    public String get_id () {
        return _id;
    }

    public void set_id ( String _id ) {
        this._id = _id;
    }*/
}
