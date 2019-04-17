package com.malta.serialization.readResolve;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

	SingletonPerson p = SingletonPerson.getInstance();
	System.out.println("Before Serialization instance is " + p);
	FileOutputStream fos = new FileOutputStream("moulutant.ser");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(p);
	FileInputStream fis = new FileInputStream("moulutant.ser");
	ObjectInputStream ois = new ObjectInputStream(fis);
	p = (SingletonPerson)ois.readObject();
	System.out.println("Serialized Object is " + p);
	oos.close();
	ois.close();

    }

}
