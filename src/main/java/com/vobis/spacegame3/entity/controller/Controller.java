package com.vobis.spacegame3.entity.controller;

import com.vobis.spacegame3.entity.EntityShip;
import com.vobis.spacegame3.entity.component.ControllableComponent;

public abstract class Controller {

    protected final EntityShip ship;

    public Controller(EntityShip ship) {
        this.ship = ship;
    }

    public abstract void update();

    public EntityShip getShip() {
        return ship;
    }
}
