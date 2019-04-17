package com.malta.serialization.inheritance.parentNotSerializable;

import java.io.IOException;

import com.malta.utility.SerializationUtility;

public class MainApp {

    public static void main(String args[]) throws IOException, ClassNotFoundException {

	// All the fields of the parent class are deserialized and set to the default
	// values
	Employee god = new Employee("Ganesh", 112, "03-03-1987", "109374", "God");
	System.out.println(SerializationUtility.deSerialize(SerializationUtility.serialize(god)));

	Merchant merchant = new Merchant("Vaibhav", 36, "04-09-1982", "Vaibhav Consulting", "DL-12M-O89M2");
	System.out.println(SerializationUtility.deSerialize(SerializationUtility.serialize(merchant)));
    }
}
