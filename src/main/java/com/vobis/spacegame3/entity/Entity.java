package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.component.GameComponent;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    protected World world;

    public void init(World world) {
        this.world = world;
    }

    public final List<Class<? extends GameComponent>> getComponents() {
        List<Class<? extends GameComponent>> result = new ArrayList();

        Class current = getClass();

        do {
            Class components[] = current.getInterfaces();

            for (Class component : components) {
                result.add(component);
            }
        } while ((current = current.getSuperclass()) != null);

        return result;
    }
}
