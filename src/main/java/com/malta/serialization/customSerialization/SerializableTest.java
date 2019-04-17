package com.malta.serialization.customSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest implements Serializable {
    private String firstData;
    //transient field, shouldn't be serialized.
    transient private String secondData;

    public SerializableTest(String firstData, String test2) {
        this.firstData = firstData;
        this.secondData = test2;
    }

    /**
     * Private method, same signature as in Serializable interface
     *
     * @param stream
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(secondData);
    }

    /**
     * Private method, same signature as in Serializable interface
     *
     * @param stream
     * @throws IOException
     */
    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        secondData = (String) stream.readObject();

    }

    @Override
    public String toString() {
        return "SerializationTest{" +
                "firstData='" + firstData + '\'' +
                ", secondData='" + secondData + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("object.out");
            oos = new ObjectOutputStream(fos);
            SerializableTest sTest = new SerializableTest("First Data", "Second data");
            oos.writeObject(sTest);
        } finally {
            oos.close();
            fos.close();
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("object.out");
            ois = new ObjectInputStream(fis);
            SerializableTest sTest2 = (SerializableTest) ois.readObject();
            System.out.println(sTest2);
        } finally {
            ois.close();
            fis.close();
        }
        //Output:
        //SerializationTest{firstData='First Data', secondData='Second data'}
    }
}