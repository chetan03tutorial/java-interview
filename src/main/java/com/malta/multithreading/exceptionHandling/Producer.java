package com.malta.multithreading.exceptionHandling;

import java.util.Random;

public class Producer {

    public void produce() {
	Random random = new Random();
	while (true) {
	    try {
		try {
		    Thread.sleep(200);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		int counter = random.nextInt(5);
		System.out.println("Item produced is " + counter);
		if (counter == 0) {
		    throw new IllegalStateException();
		}
	    } catch (IllegalStateException ex) {
		System.err.println("Illegal State exception has occurred in the thread");
		System.err.println(", Only local cache of the thread would be aware of it");
		throw ex;
	    }
	}
    }
}
