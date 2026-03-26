package game;

import java.awt.Graphics;
import java.awt.Color;

/**
 * Represents the goal area used for scoring.
 * The goal rotates and is drawn on the screen.
 */
public class Goal extends Polygon implements GameObject {

    /**
     * Constructs a Goal with the specified shape, position, and rotation.
     *
     * @param shape the polygon points defining the goal shape
     * @param position the center position of the goal
     * @param rotation the initial rotation in degrees
     */
    public Goal(Point[] shape, Point position, double rotation) {
        super(shape, position, rotation);
    }

    /**
     * Updates the goal's state by rotating it
     */
    public void move() {
        this.rotate(1);
    }

    /**
     * Draws the goal on the screen
     *
     * @param brush the graphics context used for drawing.
     */
    public void paint(Graphics brush) {
        Point[] points = getPoints();
        int[] x = new int[points.length];
        int[] y = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            x[i] = (int) points[i].x;
            y[i] = (int) points[i].y;
        }

        brush.setColor(Color.GREEN);
        brush.fillPolygon(x, y, points.length);
    }
}