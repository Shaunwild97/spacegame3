package com.vobis.spacegame3;

import org.newdawn.slick.Graphics;

public class Screen {
    private Graphics g;

    public Screen(Graphics g) {
        this.g = g;
    }

    public void drawRectangle(double x, double y, double width, double height) {
        g.fillRect((float) x, (float) y, (float) width, (float) height);
    }

    public void drawRectangle(double x, double y, double width, double height, double dir) {
        g.rotate((float) x, (float) y, (float) dir);
        drawRectangle(x - width / 2, y - height / 2, width, height);

        g.resetTransform();
    }
}
