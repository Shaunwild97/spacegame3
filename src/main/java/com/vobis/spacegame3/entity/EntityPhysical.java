package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.component.PhysicsComponent;
import com.vobis.spacegame3.entity.component.SpaceComponent;
import com.vobis.spacegame3.game.Vector2;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public abstract class EntityPhysical extends Entity implements PhysicsComponent, SpaceComponent {

    private static final double RESISTANCE = 0.98D; //lower is more
    private static final double VELOCITY_CUTOFF = 0.01D; //the point where velocity snaps to 0
    private static final double MAX_VELOCITY = 100D;

    private double age;

    protected Vector2 pos = new Vector2();
    protected Vector2 velocity = new Vector2();
    protected double dir;
    protected boolean hasDrag = true;
    protected Shape collision = new Circle(0, 0, 5f);

    public void updatePhysics() {
        pos.add(velocity);
        age += 0.017D;
        updateCollision();

        if (hasDrag) {
            if (velocity.getLengthSq() > VELOCITY_CUTOFF) {
                velocity.multiply(RESISTANCE);
            } else {
                velocity.set(0, 0);
            }
        }

        if (velocity.getLength() > MAX_VELOCITY) {
            velocity.normalize().multiply(MAX_VELOCITY);
        }
    }

    private void updateCollision() {
        float radius = collision.getBoundingCircleRadius();
        collision.setLocation((float) pos.x - radius, (float) pos.y - radius);
    }

    @Override
    public void onCollision(PhysicsComponent other) {
        if(other.isSolid()) {
            Vector2 movement = getPos().copy().subtract(other.getPos()).normalize();
            velocity.set(movement);
        }
    }

    @Override
    public Vector2 getVelocity() {
        return velocity;
    }

    @Override
    public Shape getCollision() {
        return collision;
    }

    public Vector2 getPos() {
        return pos;
    }

    public double getDir() {
        return dir;
    }

    public double getAge() {
        return age;
    }
}
