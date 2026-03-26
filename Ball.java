package game;

import java.awt.Graphics;
import java.awt.Color;

/**
 * Represents the soccer ball used during gameplay.
 * The ball rotates continuously and is drawn on the screen.
 */
public class Ball extends Polygon implements GameObject {

    /**
     * Constructs a Ball with the specified shape, position, and rotation.
     *
     * @param shape the polygon points defining the ball shape
     * @param position the center position of the ball
     * @param rotation the initial rotation in degrees
     */
    public Ball(Point[] shape, Point position, double rotation) {
        super(shape, position, rotation);
    }

    /**
     * Updates the ball's state by rotating it
     */
    public void move() {
        this.rotate(1);
    }

    /**
     * Draws the ball on the screen.
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

        brush.setColor(Color.WHITE);
        brush.fillPolygon(x, y, points.length);
    }
}