package com.malta.serialization.inheritance.parentNotSerializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Merchant extends Person implements Serializable{
    private String shopName;
    private String liscenceNumber;
    
    public Merchant(String name, int age, String dob, String shopName, String liscenceNumber) {
	super(shopName, age, dob);
	this.shopName = shopName;
	this.liscenceNumber = liscenceNumber;
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
	ois.defaultReadObject();
	String deserializedName = (String)ois.readObject();
	setName(deserializedName);
	int deserializedAge = (int)ois.readInt();
	setAge(deserializedAge);
	setDob((String)ois.readObject());
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException{
	oos.defaultWriteObject();
	oos.writeObject(this.getName());
	oos.writeInt(this.getAge());
	oos.writeObject(this.getDob());
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLiscenceNumber() {
        return liscenceNumber;
    }

    public void setLiscenceNumber(String liscenceNumber) {
        this.liscenceNumber = liscenceNumber;
    }
    
    

}
