package com.malta.nestedClasses;

public class Runner {

    public static void main(String[] args) {
	Container container = new Container(10, 20);
	container.displayCounter();
	container.displayVersion();
	/*Position position = container.getPosition();
	System.out.println("Returned position is " + position.getPosition());*/
	/*Position position = container.new Position();
	System.out.println("Another returned position is " + position.getPosition());*/
	/*Container.Holder holder = new Container.Holder();
	System.out.println("Holder version id is " + holder.getImprovisedVersion());*/
    }
}
