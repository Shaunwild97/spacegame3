package com.vobis.spacegame3.game.camera;

import com.vobis.spacegame3.entity.component.SpaceComponent;
import com.vobis.spacegame3.game.Vector2;

public class TrackingCamera implements Camera{

    private double scale = 1d;
    private SpaceComponent trackedEntity;

    public TrackingCamera(SpaceComponent trackedEntity) {
        this.trackedEntity = trackedEntity;
    }

    @Override
    public double getScale() {
        return scale;
    }

    @Override
    public Vector2 getPos() {
        return trackedEntity.getPos();
    }

    public void setTrackedEntity(SpaceComponent trackedEntity) {
        this.trackedEntity = trackedEntity;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
