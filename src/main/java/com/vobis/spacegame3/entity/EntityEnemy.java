package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.controller.AIController;
import com.vobis.spacegame3.game.Screen;

public class EntityEnemy extends EntityShip {

    public EntityEnemy() {
        team = 1;
        setController(new AIController(this));
    }

    @Override
    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 30, 30, dir);
    }
}
