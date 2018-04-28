package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.component.ControllableComponent;
import com.vobis.spacegame3.entity.component.RenderComponent;
import com.vobis.spacegame3.entity.component.TeamComponent;
import com.vobis.spacegame3.entity.component.UpdateComponent;
import org.newdawn.slick.geom.Circle;

public abstract class EntityShip extends EntityPhysical implements RenderComponent, UpdateComponent, ControllableComponent, TeamComponent {

    protected double speed = 0.3D;
    protected double turnSpeed = 3;
    protected double fireSpeed = 0.25d;
    protected int team;

    private double fireTimer;

    public EntityShip() {
        collision = new Circle(0, 0, 20);
    }

    @Override
    public void update() {
        if (fireTimer > 0) {
            fireTimer -= 0.017D;
        }
    }

    public void up() {
        velocity.addDirection(dir, speed);
    }

    public void down() {
        velocity.addDirection(dir, -speed);
    }

    public void left() {
        dir -= turnSpeed;
    }

    public void right() {
        dir += turnSpeed;
    }

    public void brake() {
        velocity.multiply(0.9D);
    }

    public void boost() {
        velocity.multiply(1.1D);
    }

    public void fire() {
        if(fireTimer <= 0) {
            EntityBullet bullet = new EntityBullet(this);
            bullet.pos.set(pos);
            world.add(bullet);
            fireTimer = fireSpeed;
        }
    }

    public int getTeam() {
        return team;
    }
}
