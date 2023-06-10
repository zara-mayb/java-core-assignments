package com.zmb.zookeeper;

public class Bat extends Mammal{
	public Bat() {
		super(300);
	}
	public void fly() {
		energy -= 50;
		System.out.println("Bat taking off , Energy lost:" + 50);
		displayEnergy();
	}
	public void eatHumans() {
		energy += 25;
		System.out.println("so- well.. , Energy gained:" + 25);
		displayEnergy();
	}
	public void attackTown() {
		energy -= 100;
		System.out.println("AHHHHHH , Energy lost:" + 100);
		displayEnergy();
	}
}
