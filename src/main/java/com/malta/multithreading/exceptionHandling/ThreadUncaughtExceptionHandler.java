package com.malta.multithreading.exceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadUncaughtExceptionHandler implements UncaughtExceptionHandler{

    public void uncaughtException(Thread t, Throwable e) {
	System.err.println("Caught the unchecked exception of the thread  " + t.getName());
	// Log the exception
	System.err.println(e);
	// wrap it in the runtime exception and throw it to the caller
	throw new RuntimeException(e);
    }

    
    
}
