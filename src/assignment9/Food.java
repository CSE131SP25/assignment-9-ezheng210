package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.x = 0.02 + Math.random() *(0.97);
		this.y = 0.02 + Math.random()*(0.97);
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(Color.red);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}

	public double getX() {
		return x;
	
	}

	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
}
