package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.Screen;

public class EntityPlayer extends EntityShip {

    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 40, 40, dir);
    }
}
