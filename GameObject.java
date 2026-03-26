package game;

import java.awt.Graphics;

/**
 * Interface defining behavior for all game objects.
 * All game objects must be able to move and be drawn.
 */
public interface GameObject {

    /**
     * Updates the state or position of the object.
     */
    void move();

    /**
     * Draws the object using the specified graphics context.
     *
     * @param g the graphics context used for drawing.
     */
    void paint(Graphics g);
}