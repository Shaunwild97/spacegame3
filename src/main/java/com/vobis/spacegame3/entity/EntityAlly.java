package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.controller.AIController;
import com.vobis.spacegame3.game.Screen;
import com.vobis.spacegame3.game.World;

public class EntityAlly extends EntityShip{

    public EntityAlly() {
        team = 0;
    }

    @Override
    public void init(World world) {
        super.init(world);
        setController(new AIController(this));
    }

    @Override
    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 40, 40, dir);
    }
}
