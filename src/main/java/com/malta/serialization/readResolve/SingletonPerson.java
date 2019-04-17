package com.malta.serialization.readResolve;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonPerson implements Serializable{
    
    private static final long serialVersionUID = 44L;
    private static final SingletonPerson instance = new SingletonPerson();
    private String name;
    private int age;
    private String dob;
    transient private String gender;
    
    
    public static SingletonPerson getInstance() {
	return instance;
    }
    
    private SingletonPerson() {
	
    }
    
    private Object readResolve() throws ObjectStreamException{
	return instance;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    
}
