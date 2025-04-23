package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	private int score;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = new Food();
		score =0;
	}
	
	public void play() {
		while (snake.isInbounds()) { 
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			if(dir != -1) {
				snake.changeDirection(dir);
			}
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			snake.move();
			if(snake.eatFood(food)) {
				score ++;
				food = new Food();
			}
			
			updateDrawing();
		}
		showGameOverScreen();
		System.out.println("Game Over!");
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.textLeft(0.01, 0.98, "Score: " + score);
		StdDraw.pause(50);
		StdDraw.show();
	}
	private void showIntroScreen() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.6, "Welcome to Snake");
		StdDraw.text(0.5, 0.5, "Use W A S D to move");
		StdDraw.text(0.5, 0.4, "Press any key to start.");
		StdDraw.show();
		while (!StdDraw.hasNextKeyTyped()) {
			
		}
		StdDraw.hasNextKeyTyped();
	}
	private void showGameOverScreen() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(0.5, 0.6, "Game Over!");
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.5, "Thanks for playing.");
		StdDraw.text(0.5, 0.4, "Close the window to exit.");
		StdDraw.show();

		while (true) {
			// Freeze on game over screen
		}
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.showIntroScreen();
		g.play();
	}
}
