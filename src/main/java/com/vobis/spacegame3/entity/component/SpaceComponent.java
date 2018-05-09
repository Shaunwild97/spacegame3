package com.vobis.spacegame3.entity.component;

import com.vobis.spacegame3.game.Vector2;

public interface SpaceComponent extends GameComponent {

    Vector2 getPos();

    double getDir();
}
