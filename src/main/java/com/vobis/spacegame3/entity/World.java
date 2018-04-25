package com.vobis.spacegame3.entity;

import com.vobis.spacegame3.entity.component.GameComponent;
import com.vobis.spacegame3.entity.component.UpdateComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class World {

    private HashMap<Class<? extends GameComponent>, List<? extends GameComponent>> componentMap;

    public World() {
        componentMap = new HashMap<Class<? extends GameComponent>, List<? extends GameComponent>>();
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
        for (UpdateComponent component : getComponents((UpdateComponent.class))) {
            component.update();
        }
    }

    public void add(Entity entity) {
        List<Class<? extends GameComponent>> entityComponents = entity.getComponents();

        for(Class component : entityComponents) {
            getComponents(component).add(entity);
        }

        entity.init(this);
    }
}
