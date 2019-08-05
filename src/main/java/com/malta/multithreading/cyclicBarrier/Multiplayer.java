package com.malta.multithreading.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Multiplayer implements Runnable {

    private CyclicBarrier barrier;

    public Multiplayer(CyclicBarrier latch) {
	this.barrier = latch;
    }

    public void run() {
	System.out.println("waiting for all threads to arrive");
	try {
	    barrier.await();
	    System.out.println("Game Initialized");
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (BrokenBarrierException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) throws InterruptedException {
	CyclicBarrier barrier = new CyclicBarrier(5);
	Multiplayer game = new Multiplayer(barrier);
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
    }
}