package com.vobis.spacegame3.entity.component;

public interface PoolableComponent {
    boolean isActive();

    void resetState();
}
