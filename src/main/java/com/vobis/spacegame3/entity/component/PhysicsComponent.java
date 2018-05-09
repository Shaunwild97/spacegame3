package com.vobis.spacegame3.entity.component;

import com.vobis.spacegame3.game.Vector2;
import org.newdawn.slick.geom.Shape;

public interface PhysicsComponent extends SpaceComponent {
    void updatePhysics();

    Shape getCollision();

    Vector2 getVelocity();

    default void onCollision(PhysicsComponent other) {
    }

    default boolean isSolid() {
        return true;
    }
}
