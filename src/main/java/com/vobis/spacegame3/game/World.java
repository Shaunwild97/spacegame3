package com.vobis.spacegame3.game;

import com.vobis.spacegame3.SpaceGameApp;
import com.vobis.spacegame3.entity.Entity;
import com.vobis.spacegame3.entity.component.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class World {

    private HashMap<Class<? extends GameComponent>, List<? extends GameComponent>> componentMap;
    private List<Entity> entityList;
    private Random rand;

    public World() {
        componentMap = new HashMap<>();
        entityList = new ArrayList<>();
        rand = new Random(1337);
    }

    public <T extends GameComponent> List<T> getComponents(Class<T> type) {
        List result = componentMap.get(type);

        if (result == null) {
            result = new ArrayList();
            componentMap.put(type, result);
        }

        return (List<T>) result;
    }

    public void update() {
        updateComponents();
        updatePhysics();
        removeDeadEntities();
    }

    private void updatePhysics() {
        List<PhysicsComponent> physicsComponents = getComponents(PhysicsComponent.class);

        for (PhysicsComponent component : physicsComponents) {
            component.updatePhysics();

            for (PhysicsComponent other : physicsComponents) {
                if (component == other) {
                    continue;
                }

                if (component.getCollision().intersects(other.getCollision())) {
                    component.onCollision(other);
                }
            }
        }
    }

    private void updateComponents() {
        for (UpdateComponent component : getComponents((UpdateComponent.class))) {
            component.update();
        }
    }

    private void removeDeadEntities() {
        for (int i = 0; i < entityList.size(); i++) {
            Entity e = entityList.get(i);

            if (!e.isAlive()) {
                entityList.remove(e);
                remove(e);
            }
        }
    }

    public <T extends SpaceComponent> T getNearestSpaceComponent(SpaceComponent entity, Class<T> type) {
        return (T) getComponents(SpaceComponent.class).stream()
                .filter(e -> e != entity)
                .filter(e -> e.getClass().isAssignableFrom(type))
                .sorted((s1, s2) -> (int) (s1.getPos().getDistanceSq(entity.getPos()) - s2.getPos().getDistanceSq(entity.getPos())))
                .findFirst().get();
    }

    public <T extends SpaceComponent> T getNearestSpaceComponent(SpaceComponent entity, Predicate<SpaceComponent> filter) {
        return (T) getComponents(SpaceComponent.class).stream()
                .filter(e -> e != entity)
                .filter(filter)
                .sorted((s1, s2) -> (int) (s1.getPos().getDistanceSq(entity.getPos()) - s2.getPos().getDistanceSq(entity.getPos())))
                .findFirst().orElse(null);
    }

    public void add(Entity entity) {
        List<Class<? extends GameComponent>> entityComponents = entity.getComponents();

        for (Class component : entityComponents) {
            getComponents(component).add(entity);
        }

        entityList.add(entity);
        entity.init(this);
    }

    public void remove(Entity entity) {
        List<Class<? extends GameComponent>> entityComponents = entity.getComponents();

        for (Class component : entityComponents) {
            getComponents(component).remove(entity);
        }

        entityList.remove(entity);
    }

    public void render(Screen screen) {
        for (RenderComponent component : getComponents((RenderComponent.class))) {
            component.render(screen);
        }

        if (SpaceGameApp.DEBUG) {
            for (PhysicsComponent component : getComponents((PhysicsComponent.class))) {
                screen.drawShape(component.getCollision());
            }
        }
    }

    public Random getRand() {
        return rand;
    }
}
