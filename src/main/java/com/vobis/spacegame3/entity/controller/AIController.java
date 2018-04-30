package com.vobis.spacegame3.entity.controller;

import com.vobis.spacegame3.entity.EntityShip;

public class AIController extends Controller {

    public AIController(EntityShip ship) {
        super(ship);
    }

    @Override
    public void update() {
        ship.fire();
    }
}
