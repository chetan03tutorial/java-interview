package com.malta.generic.covariant;

public class ArrayAsCovariantAndRefied {

    public static void main(String[] args) {
	Object[] array = new Long[2];
	array[0] = "This is Illegal";

	System.out.println("At runtime we should get a runtime exception, because "
		+ "we are trying to set a string in long container");

	try {
	    System.out.println("Value of array[0] is " + array[0]);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
