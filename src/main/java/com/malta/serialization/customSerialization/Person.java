package com.malta.serialization.customSerialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.malta.utility.JsonResolver;

public class Person implements Serializable {

    private static final long serialVersionUID = 43L;
    private String name;
    private int age;
    private String dob;
    transient private String gender;

    Person(String name, int age, String dob) {
	this.name = name;
	this.age = age;
	this.dob = dob;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	/**
	 * use the default serialization mechanism, under this gender won't be
	 * serialized , but we are going to overriding readObject to customize the
	 * behaviour
	 */
	ois.defaultReadObject();
	/**
	 * we need to assign this value back to gender field, otherwise it would not be
	 * picked up at the time of creating the object.
	 */
	gender = (String) ois.readObject();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
	/**
	 * Using the default serialization along with custom serialization to serialize
	 * the transient field
	 */
	oos.defaultWriteObject();
	oos.writeObject(gender);
	oos.flush();
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
