package com.malta.serialization.inheritance.parentNotSerializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Employee extends Person implements Serializable {
    
    private static final long serialVersionUID = 45L;
    private String employeeId;
    private String designation;
    
    public Employee(String name, int age, String dob, String employeeId, String designation) {
	super(name, age, dob);
	this.employeeId = employeeId;
	this.designation = designation;
    }
    
    private Object writeReplace() throws  ObjectStreamException{
	System.out.println("Write replace is called");
	System.out.println("Invoker is " + this);
	return this;
    }
    
    private Object readResolve() throws ObjectStreamException{
	System.out.println("Read resolve is called");
	System.out.println("Invoker is " + this);
	return this;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
}
