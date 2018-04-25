package com.vobis.spacegame3;

import org.newdawn.slick.*;

public class SpaceGameApp extends BasicGame {

    public static void main(String args[]) throws SlickException {
        AppGameContainer container = new AppGameContainer(new SpaceGameApp());
        container.setDisplayMode(512, 512, false);
        container.start();
    }

    public SpaceGameApp() {
        super("Space Game 3");
    }

    @Override
    public void init(GameContainer gameContainer) {

    }

    @Override
    public void update(GameContainer gameContainer, int i) {
    }

    public void render(GameContainer gameContainer, Graphics graphics) {

    }
}
