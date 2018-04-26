package com.vobis.spacegame3.entity.component;

import com.vobis.spacegame3.Vector2;

public interface SpaceComponent extends GameComponent {

    public Vector2 getPos();

    public double getDir();
}
