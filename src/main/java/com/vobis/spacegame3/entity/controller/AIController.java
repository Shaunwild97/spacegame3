package com.vobis.spacegame3.entity.controller;

import com.vobis.spacegame3.entity.EntityShip;
import com.vobis.spacegame3.entity.component.TeamComponent;
import com.vobis.spacegame3.game.Vector2;
import com.vobis.spacegame3.game.World;

public class AIController extends Controller {

    private int chaseDistanceSq = 400*400;

    private World world;

    public AIController(EntityShip ship) {
        super(ship);
        this.world = ship.getWorld();
    }

    @Override
    public void update() {
        EntityShip target = world.getNearestSpaceComponent(ship, s -> {
            if (s instanceof EntityShip && s instanceof TeamComponent) {
                return ((TeamComponent) s).getTeam() != ship.getTeam();
            }

            return false;
        });

        if(target != null) {
            handleFiring(target);
            handleMovement(target);
        }
    }

    private void handleFiring(EntityShip target) {
        double leadOffset = 30 + (world.getRand().nextInt(50));
        Vector2 aimPoint = target.getPos().copy().add(target.getVelocity().copy().multiply(leadOffset));

        double theta = ship.getPos().angleTo(aimPoint);
        double delta = ship.getDir() - theta;

        if(delta > 180) {
            delta -= 360;
        }

        if (delta > 3) {
            ship.left();
        } else if (delta < -3) {
            ship.right();
        } else {
            ship.fire();
        }
    }

    private void handleMovement(EntityShip target) {
        double distanceSq = ship.getPos().getDistanceSq(target.getPos());

        if(distanceSq > chaseDistanceSq) {
            ship.up();
        } else {
            ship.brake();
        }
    }

    public void setChaseDistance(int chaseDistance) {
        this.chaseDistanceSq = chaseDistance * chaseDistance;
    }
}
