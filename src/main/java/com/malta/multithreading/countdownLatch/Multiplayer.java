package com.malta.multithreading.countdownLatch;

import java.util.concurrent.CountDownLatch;

public class Multiplayer implements Runnable {

    private CountDownLatch latch;
    
    public Multiplayer(CountDownLatch latch) {
	this.latch = latch;
    }
    
    public void run() {
	System.out.println("waiting for all threads to arrive");
	latch.countDown();
	
    }
    
    public static void main(String[] args) throws InterruptedException {
	CountDownLatch latch = new CountDownLatch(5);
	Multiplayer game = new Multiplayer(latch);
	Thread t1 = new Thread(game);
	Thread t2 = new Thread(game);
	Thread t3 = new Thread(game);
	Thread t4 = new Thread(game);
	Thread t5 = new Thread(game);
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	
	latch.await();
	System.out.println("All threads arrived");
	System.out.println("Start the game");
	
    }
    
}
