package com.vobis.spacegame3;

import com.vobis.spacegame3.entity.EntityPlayer;
import com.vobis.spacegame3.entity.World;
import com.vobis.spacegame3.entity.component.UpdateComponent;
import org.newdawn.slick.*;

public class SpaceGameApp extends BasicGame {

    private static int GAME_TPS = 60;
    private static int GAME_TICK = 1000 / GAME_TPS;

    private int deltaCounter;

    private World world;

    public SpaceGameApp() {
        super("Space Game 3");
    }

    @Override
    public void init(GameContainer gameContainer) {
        System.out.println("Game Started");

        world = new World();
        EntityPlayer player = new EntityPlayer();

        world.add(player);

        System.out.println(world.getComponents(UpdateComponent.class));
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        deltaCounter += delta;

        if (deltaCounter >= GAME_TICK) {
            deltaCounter = 0;

            if (world != null) {
                world.update();
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) {

    }

    public static void main(String args[]) throws SlickException {
        AppGameContainer container = new AppGameContainer(new SpaceGameApp());
        container.setDisplayMode(1024, 512, false);
        container.start();
    }
}
