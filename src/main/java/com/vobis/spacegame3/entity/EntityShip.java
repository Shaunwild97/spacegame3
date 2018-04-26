package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.component.ControllableComponent;
import com.vobis.spacegame3.entity.component.RenderComponent;
import com.vobis.spacegame3.entity.component.UpdateComponent;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public abstract class EntityShip extends EntityPhysical implements RenderComponent, UpdateComponent, ControllableComponent {

    protected double speed = 0.3D;
    protected double size = 20;
    protected double turnSpeed = 3;

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
        EntityBullet bullet = new EntityBullet(this);
        bullet.pos.set(pos);
        world.add(bullet);
    }

    public Shape getCollision() {
        return new Circle((float)pos.x, (float)pos.y, (int)size);
    }
}
