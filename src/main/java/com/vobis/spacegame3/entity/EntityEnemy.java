package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.controller.AIController;
import com.vobis.spacegame3.game.Screen;
import com.vobis.spacegame3.game.World;

public class EntityEnemy extends EntityShip {

    public EntityEnemy() {
        team = 1;
    }

    @Override
    public void init(World world) {
        super.init(world);
        setController(new AIController(this));
    }

    @Override
    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 30, 30, dir);
    }
}
