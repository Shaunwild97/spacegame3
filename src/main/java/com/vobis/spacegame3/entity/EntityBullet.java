package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.Screen;
import com.vobis.spacegame3.entity.component.PhysicsComponent;
import com.vobis.spacegame3.entity.component.RenderComponent;
import com.vobis.spacegame3.entity.component.TeamComponent;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class EntityBullet extends EntityPhysical implements TeamComponent, RenderComponent {

    private EntityShip owner;

    public EntityBullet(EntityShip owner) {
        this.owner = owner;

        hasDrag = false;
        setFlightPath();
    }

    private void setFlightPath() {
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

        velocity.multiply(-1);
    }

    public Shape getCollision() {
        return new Circle((float) pos.x, (float) pos.y, 5);
    }

    public int getTeam() {
        return owner.getTeam();
    }

    public void render(Screen screen) {
        screen.drawRectangle(pos.x, pos.y, 5, 5, dir);
    }
}
