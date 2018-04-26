package com.vobis.spacegame3.entity.component;

public interface PoolableComponent {
    public boolean isActive();

    public void resetState();
}
