package com.vobis.spacegame3.entity.component;

public interface GameComponent {
    default boolean isAlive() {
        return true;
    }
}
