package com.vobis.spacegame3.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Screen {
    private Graphics g;

    public Screen(Graphics g) {
        this.g = g;
    }

    public void drawRectangle(double x, double y, double width, double height) {
        g.fillRect((float) (x - width / 2), (float) (y - height / 2), (float) width, (float) height);
    }

    public void drawRectangle(double x, double y, double width, double height, double dir) {
        g.rotate((float) x, (float) y, (float) dir);
        drawRectangle(x, y, width, height);

        g.resetTransform();
    }

    public void drawShape(Shape shape) {
        g.draw(shape);
    }
}
