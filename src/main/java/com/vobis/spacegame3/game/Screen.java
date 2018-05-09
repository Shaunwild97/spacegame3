package com.vobis.spacegame3.game;

import com.vobis.spacegame3.game.camera.Camera;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Screen {
    private Graphics g;
    private Camera camera;

    public void init(Graphics g) {
        this.g = g;
        g.setAntiAlias(true);
    }

    public void update() {
        if (camera != null) {
            Vector2 pos = camera.getPos();

            g.translate((float) pos.x, (float) pos.y);
            g.scale((float) camera.getScale(), (float) camera.getScale());
        }
    }

    public boolean isReady() {
        return g != null;
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

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
