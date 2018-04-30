package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.controller.PlayerController;
import com.vobis.spacegame3.game.Screen;

public class EntityPlayer extends EntityShip {

    public EntityPlayer() {
        setController(new PlayerController(this));
    }

    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 40, 40, dir);
    }
}
