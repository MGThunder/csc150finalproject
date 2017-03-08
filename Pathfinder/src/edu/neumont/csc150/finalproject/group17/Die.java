package edu.neumont.csc150.finalproject.group17;

import java.util.Random;

public class Die {
	public Random rand;
	public int num;
	
	public Die() {
		rand = new Random();
	}
	
	public int rollDice(int sides) {
		num = rand.nextInt(sides) + 1;
		return num;
	}
}