package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.Screen;

public class EntityEnemy extends EntityShip {

    @Override
    public void update() {
        fire();
    }

    @Override
    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 30, 30, dir);
    }
}
