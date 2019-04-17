package com.malta.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtility {

    
    public static byte[] serialize(Object arg) throws IOException {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(baos);
	oos.writeObject(arg);
	oos.flush();
	oos.close();
	return baos.toByteArray();
    }
    
    public static Object deSerialize(byte[] arg) throws IOException, ClassNotFoundException {
	ByteArrayInputStream bais = new ByteArrayInputStream(arg);
	ObjectInputStream ois = new ObjectInputStream(bais);
	Object object = ois.readObject();
	ois.close();
	return object;
    }
}
