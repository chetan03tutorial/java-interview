package com.malta.multithreading.exceptionHandling;

public class ProducerThreadWithExceptionHandling {

    public static void main(String[] args) {
	final Producer producerProcess = new Producer();
	
	try {
	    Thread t = new Thread(new Runnable() {
		public void run() {
		    producerProcess.produce();
		}
	    });
	    t.setUncaughtExceptionHandler(new ThreadUncaughtExceptionHandler());
	    t.start();
	} catch (RuntimeException ex) {
	    System.err.println("Never got the exception of a different thread in current thread");
	}

    }
}
