package com.vobis.spacegame3.entity.component;

public interface GameComponent {
    public default boolean isAlive() {
        return true;
    }
}
