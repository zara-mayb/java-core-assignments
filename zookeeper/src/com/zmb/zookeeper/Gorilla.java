package com.zmb.zookeeper;

public class Gorilla extends Mammal {
	public Gorilla() {
		super(100);
	}
	public void throwSomething() {
		energy -= 5;
		System.out.println("Gorilla has thrown something" + " Energy Lost:" + 5);
		displayEnergy();
	}
	public void eatBananas() {
		energy += 10;
		System.out.println("Gorilla is satisfied" + " Energy Gained:" + 10 );
		displayEnergy();
	}
	public void climb() {
		energy -= 10;
		System.out.println("Gorilla has climbed a tree" + " Energy lost:" + 10 );
		displayEnergy();
	}
}
