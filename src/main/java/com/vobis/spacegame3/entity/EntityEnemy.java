package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.Screen;

public class EntityEnemy extends EntityShip {

    public EntityEnemy() {
        team = 1;
    }

    @Override
    public void update() {
        super.update();
        fire();
    }

    @Override
    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 30, 30, dir);
    }
}
