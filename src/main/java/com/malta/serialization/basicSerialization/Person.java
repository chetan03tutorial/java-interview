package com.malta.serialization.basicSerialization;

import java.io.Serializable;

import com.malta.utility.JsonResolver;

public class Person implements Serializable{
    
    
    private static final long serialVersionUID = 42L;
    private String name;
    private int age;
    private String dob;
    transient private String gender;
    
    Person(String name, int age, String dob){
	this.name = name;
	this.age = age;
	this.dob = dob;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public void setGender(String gender) {
	this.gender = gender;
    }
    
    public String getGender() {
	return this.gender;
    }
    
    @Override
    public String toString() {
	return JsonResolver.convertToJson(this);
    }
}


