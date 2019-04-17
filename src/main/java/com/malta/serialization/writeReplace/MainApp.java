package com.malta.serialization.writeReplace;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

	Person p = new Person("Moulutant", 22, "03-03-1987");
	/**
	 * Since gender is a transient field, it would be set to default value of null
	 * for String type
	 **/
	p.setGender("Male");
	System.out.println("Trying to serialize the object == " + p);
	
	FileOutputStream fos = new FileOutputStream("moulutant.ser");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(p);
	FileInputStream fis = new FileInputStream("moulutant.ser");
	ObjectInputStream ois = new ObjectInputStream(fis);
	p = (Person)ois.readObject();
	System.out.println("Serialized Object is " + p);
	oos.close();
	ois.close();

    }

}
