package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.component.PhysicsComponent;
import com.vobis.spacegame3.entity.component.SpaceComponent;
import com.vobis.spacegame3.game.Vector2;

public abstract class EntityPhysical extends Entity implements PhysicsComponent, SpaceComponent {

    private static final double RESISTANCE = 0.99D;
    private static final double VELOCITY_CUTOFF = 0.01D;
    private static final double MAX_VELOCITY = 100D;

    private double age;

    protected Vector2 pos = new Vector2();
    protected Vector2 velocity = new Vector2();
    protected double dir;
    protected boolean hasDrag = true;

    public void updatePhysics() {
        pos.add(velocity);
        age += 0.017D;

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
