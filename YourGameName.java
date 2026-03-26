package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Main game class that controls the soccer game. It creates objects, updates
 * them, and handles rendering and collisions.
 */
class YourGameName extends Game {

	static int counter = 0;

	private Player player;
	private Ball ball;
	private Goal goal;

	ScoreTracker scoreTracker = new ScoreTracker();

	/**
	 * Inner class used to track and display the score.
	 */
	public class ScoreTracker {
		int score = 0;

		/**
		 * Increments the score
		 */
		void addPoint() {
			score++;
		}

		/**
		 * Draws the score on the screen.
		 */
		void draw(Graphics brush) {
			brush.setColor(Color.white);
			brush.drawString("Score: " + score, 10, 30);
		}
	}

	/**
	 * Constructs the game and initializes all objects
	 */
	public YourGameName() {
		super("Soccer Game", 800, 600);

		this.setFocusable(true);
		this.requestFocus();

		Point[] shape = { new Point(0, 0), new Point(40, 0), new Point(40, 40), new Point(0, 40) };

		player = new Player(shape, new Point(300, 300), 0);

		Point[] ballShape = { new Point(10, 0), new Point(20, 10), new Point(10, 20), new Point(0, 10) };

		ball = new Ball(ballShape, new Point(400, 300), 0);

		Point[] goalShape = { new Point(0, 0), new Point(20, 0), new Point(20, 80), new Point(0, 80) };

		goal = new Goal(goalShape, new Point(700, 260), 0);

		this.addKeyListener(player);

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse clicked");
			}
		});

		new Thread(() -> {
			while (true) {
				player.move();
				ball.move();
				goal.move();
				repaint();
				try {
					Thread.sleep(30);
				} catch (Exception e) {
				}
			}
		}).start();
	}

	/**
	 * Draws all elements and handles game logic
	 */
	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0, 0, width, height);

		player.paint(brush);
		ball.paint(brush);
		goal.paint(brush);

		if (player.collides(ball)) {
			if (player.position.x < ball.position.x)
				ball.position.x += 10;
			else
				ball.position.x -= 10;

			if (player.position.y < ball.position.y)
				ball.position.y += 10;
			else
				ball.position.y -= 10;
		}

		if (ball.collides(goal) || goal.collides(ball)) {
			scoreTracker.addPoint();
			ball.position.x = 400;
			ball.position.y = 300;
		}

		counter++;
		brush.setColor(Color.white);
		brush.drawString("Counter: " + counter, 10, 10);

		scoreTracker.draw(brush);
	}

	public static void main(String[] args) {
		YourGameName a = new YourGameName();
		a.repaint();
	}
}