package com.vobis.spacegame3.entity.controller;

import com.vobis.spacegame3.SpaceGameApp;
import com.vobis.spacegame3.entity.EntityShip;
import org.newdawn.slick.Input;

public class PlayerController extends Controller {

    public PlayerController(EntityShip controllableComponent) {
        super(controllableComponent);
    }

    public void update() {
        Input input = SpaceGameApp.INPUT;

        if (input.isKeyDown(Input.KEY_W)) {
            ship.up();
        }

        if (input.isKeyDown(Input.KEY_S)) {
            ship.down();
        }

        if (input.isKeyDown(Input.KEY_D)) {
            ship.right();
        }

        if (input.isKeyDown(Input.KEY_A)) {
            ship.left();
        }

        if (input.isKeyDown(Input.KEY_SPACE)) {
            ship.fire();
        }

        if (input.isKeyDown(Input.KEY_LCONTROL)) {
            ship.brake();
        }
    }
}
