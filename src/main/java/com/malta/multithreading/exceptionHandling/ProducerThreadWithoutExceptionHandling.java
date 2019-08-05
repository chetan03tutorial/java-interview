package com.malta.multithreading.exceptionHandling;

public class ProducerThreadWithoutExceptionHandling {

    public static void main(String[] args) {
	final Producer producerProcess = new Producer();
	try {
	    new Thread(new Runnable() {
		public void run() {
		    producerProcess.produce();
		}
	    }).start();
	} catch (IllegalStateException ex) {
	    System.err.println("Never got the exception of a different thread in current thread");
	}

    }
}
