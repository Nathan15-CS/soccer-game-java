package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Represents the player controlled by the user.
 * The player moves and rotates based on keyboard input.
 */
public class Player extends Polygon implements GameObject, KeyListener {

    PlayerMovement movement;

    /**
     * Constructs a Player with the specified shape, position, and rotation
     *
     * @param shape the polygon points defining the player shape
     * @param position the center position of the player
     * @param rotation the initial rotation in degrees
     */
    public Player(Point[] shape, Point position, double rotation) {
        super(shape, position, rotation);
        movement = new PlayerMovement();
    }

    /**
     * Inner class used to track movement key states.
     */
    public class PlayerMovement {
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
    }

    /**
     * Updates the player's position and rotation based on key input.
     */
    public void move() {
        if (movement.up) this.position.y -= 5;
        if (movement.down) this.position.y += 5;
        if (movement.left) {
            this.position.x -= 5;
            this.rotation -= 5;
        }
        if (movement.right) {
            this.position.x += 5;
            this.rotation += 5;
        }
    }

    /**
     * Draws the player on the screen.
     *
     * @param brush the graphics context used for drawing
     */
    public void paint(Graphics brush) {
        Point[] points = getPoints();
        int[] x = new int[points.length];
        int[] y = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            x[i] = (int) points[i].x;
            y[i] = (int) points[i].y;
        }

        brush.setColor(Color.BLUE);
        brush.fillPolygon(x, y, points.length);
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) movement.up = true;
        if (key == KeyEvent.VK_DOWN) movement.down = true;
        if (key == KeyEvent.VK_LEFT) movement.left = true;
        if (key == KeyEvent.VK_RIGHT) movement.right = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) movement.up = false;
        if (key == KeyEvent.VK_DOWN) movement.down = false;
        if (key == KeyEvent.VK_LEFT) movement.left = false;
        if (key == KeyEvent.VK_RIGHT) movement.right = false;
    }
}