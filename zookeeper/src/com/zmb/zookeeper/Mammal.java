package com.zmb.zookeeper;

public class Mammal {
	public int energy;
	public Mammal(int energy) {
		this.energy = energy;
	}
	public void displayEnergy() {
		System.out.println("Energy remaining:"+ energy);
	}
}
