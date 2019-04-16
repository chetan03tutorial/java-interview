package com.malta.serialization.basicSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

	Person p = new Person("Chetan", 32, "03-03-1987");
	/**
	 * Since gender is a transient field, it would be set to default value of null
	 * for String type
	 **/
	p.setGender("Male");

	FileOutputStream fos = new FileOutputStream("chetan.ser");
	FileInputStream fis = new FileInputStream("chetan.ser");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(p);
	ObjectInputStream ois = new ObjectInputStream(fis);

	Person person = (Person) ois.readObject();
	System.out.println(person);

	oos.close();
	ois.close();

    }

}
