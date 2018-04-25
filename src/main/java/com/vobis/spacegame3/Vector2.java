package com.vobis.spacegame3;

import java.util.Vector;

/**
 * Vector2 is mutable!
 */
public class Vector2 {
    public double x, y;

    public Vector2 add(double x, double y) {
        this.x += y;
        this.y += y;
        return this;
    }

    public Vector2 add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public Vector2 multiply(double m) {
        this.x *= m;
        this.y *= m;
        return this;
    }
}
