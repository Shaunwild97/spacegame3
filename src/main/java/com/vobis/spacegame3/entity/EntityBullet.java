package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.game.Screen;
import com.vobis.spacegame3.entity.component.PhysicsComponent;
import com.vobis.spacegame3.entity.component.RenderComponent;
import com.vobis.spacegame3.entity.component.TeamComponent;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class EntityBullet extends EntityPhysical implements TeamComponent, RenderComponent {

    private static final double MAX_AGE = 3D;

    private EntityShip owner;
    private boolean collided;

    public EntityBullet(EntityShip owner) {
        this.owner = owner;

        hasDrag = false;
        setFlightPath();
    }

    private void setFlightPath() {
        velocity.set(owner.getVelocity());
        velocity.addDirection(owner.dir, 10);
    }

    @Override
    public void updatePhysics() {
        super.updatePhysics();
    }

    @Override
    public void onCollision(PhysicsComponent other) {
        if(other instanceof TeamComponent) {
            if(((TeamComponent)other).getTeam() == getTeam()) {
                return;
            }
        }

        collided = true;
    }

    @Override
    public boolean isAlive() {
        return !collided && getAge() < MAX_AGE;
    }

    public int getTeam() {
        return owner.getTeam();
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 5, 5, dir);
    }
}
