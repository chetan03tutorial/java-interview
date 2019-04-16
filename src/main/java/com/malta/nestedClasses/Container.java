package com.malta.nestedClasses;

import java.util.List;

public class Container implements Cloneable{

    private int x1;
    private int x2;
    
    private Container(Container container) {
	this.x1 = container.x1;
	this.x2 = container.x2;
    }
    
    public Container(int x1, int x2) {
	this.x1 = x1;
	this.x2 = x2;
	counter = 4;
    }
    
    private static int counter;
    
    @Override
    public Object clone() throws CloneNotSupportedException{
	return new Container(this);
    }
    
    public static Container getInstance(int x1, int x2) {
	return new Container(x1,x2);
    }
    
    public static Container getCopy(Container c) {
	return new Container(c);
    }
    
    private static class Holder {
	private static int improvisedCounter;
	
	public static int getInprovisedCounter() {
	    improvisedCounter = counter^2;
	    return improvisedCounter;
	}
	
	public int getImprovisedVersion() {
	    return 1;
	}
    }
    
    private class Position{
	private int position = 0;
	
	public int getPosition(List<?> list) {
	    
	    new Runnable() {
	        
	        public void run() {
	            System.out.println(position);
	    	
	        }
	    };
	    return position;
	}
    }
    
    public void displayCounter() {
	System.out.println("Improvised counter is " + Holder.getInprovisedCounter());
    }
    
    public void displayVersion() {
	Holder holder = new Holder();
	System.out.println(holder.getImprovisedVersion());
    }
    
    public Position getPosition() {
	Position p = new Position();
	p.position = 10;
	System.out.println("Position is " + x1*x2);
	return p;
    }
    
    
}
