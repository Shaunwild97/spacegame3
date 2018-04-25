package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.Vector2;
import com.vobis.spacegame3.entity.component.RenderComponent;
import com.vobis.spacegame3.entity.component.SpaceComponent;
import com.vobis.spacegame3.entity.component.UpdateComponent;

public abstract class EntityShip extends Entity implements SpaceComponent, RenderComponent, UpdateComponent {
    protected Vector2 pos;
    protected double dir;

    public double getX() {
        return pos.x;
    }

    public double getY() {
        return pos.y;
    }

    public double getDir() {
        return dir;
    }
}
