package com.vobis.spacegame3.entity.component;

import org.newdawn.slick.geom.Shape;

public interface PhysicsComponent extends GameComponent {
    public void updatePhysics();

    public Shape getCollision();

    public default void onCollision(PhysicsComponent other) {
    }
}
