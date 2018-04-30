package com.vobis.spacegame3.game;

/**
 * Vector2 is mutable!
 */
public class Vector2 {
    public double x, y;

    public Vector2() {
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2 set(Vector2 other) {
        this.x = other.x;
        this.y = other.y;
        return this;
    }

    public Vector2 add(double x, double y) {
        this.x += y;
        this.y += y;
        return this;
    }

    public Vector2 subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2 subtract(Vector2 other) {
        this.x -= other.x;
        this.y -= other.y;
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

    public Vector2 addDirection(double dir, double magnitude) {
        double radian = Math.toRadians(dir);

        double x = Math.sin(radian);
        double y = Math.cos(radian);

        this.x += x * magnitude;
        this.y -= y * magnitude;

        return this;
    }

    public double getLength() {
        double lengthSq = getLengthSq();
        return Math.sqrt(lengthSq);
    }

    public double getLengthSq() {
        double result = x * x + y * y;
        return result;
    }

    public double getDistance(Vector2 other) {
        double distSq = getDistanceSq(other);
        return Math.sqrt(distSq);
    }

    public double getDistanceSq(Vector2 other) {
        double xd = other.x - x;
        double yd = other.y - y;
        double result = xd * xd + yd * yd;

        return result;
    }

    public Vector2 normalize() {
        double length = getLength();

        x /= length;
        y /= length;

        return this;
    }

    public double angleTo(Vector2 other) {
        double xd = other.x - x;
        double yd = other.y - y;

        double angle = Math.toDegrees(Math.atan2(yd, xd)) + 90;

        if(angle < 0) {
            angle += 360;
        }

        return angle;
    }

    public Vector2 copy() {
        return new Vector2(this.x, this.y);
    }
}
