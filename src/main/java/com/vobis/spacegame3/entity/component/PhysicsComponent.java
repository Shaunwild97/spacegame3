package com.vobis.spacegame3.entity.component;

import com.vobis.spacegame3.game.Vector2;
import org.newdawn.slick.geom.Shape;

public interface PhysicsComponent extends SpaceComponent {
    public void updatePhysics();

    public Shape getCollision();

    public Vector2 getVelocity();

    public default void onCollision(PhysicsComponent other) {
    }

    public default boolean isSolid() {
        return true;
    }
}
