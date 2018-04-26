package com.vobis.spacegame3;

import com.vobis.spacegame3.entity.EntityEnemy;
import com.vobis.spacegame3.entity.EntityPlayer;
import com.vobis.spacegame3.game.World;
import com.vobis.spacegame3.game.Screen;
import org.newdawn.slick.*;

public class SpaceGameApp extends BasicGame {

    private static int GAME_TPS = 60;
    private static int GAME_TICK = 1000 / GAME_TPS;

    private int deltaCounter;

    private World world;
    private Screen screen;

    private EntityPlayer thePlayer;

    public SpaceGameApp() {
        super("Space Game 3");
    }

    @Override
    public void init(GameContainer gameContainer) {
        System.out.println("Game Started");

        world = new World();
        thePlayer = new EntityPlayer();
        thePlayer.getPos().set(512, 256);

        EntityEnemy testEnemy = new EntityEnemy();
        testEnemy.getPos().set(200, 256);

        world.add(thePlayer);
        world.add(testEnemy);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        deltaCounter += delta;

        if (deltaCounter >= GAME_TICK) {
            deltaCounter = 0;

            if (world != null) {
                world.update();

                Input input = gameContainer.getInput();

                if(input.isKeyDown(Input.KEY_W)) {
                    thePlayer.up();
                }

                if(input.isKeyDown(Input.KEY_S)) {
                    thePlayer.down();
                }

                if(input.isKeyDown(Input.KEY_D)) {
                    thePlayer.right();
                }

                if(input.isKeyDown(Input.KEY_A)) {
                    thePlayer.left();
                }

                if(input.isKeyDown(Input.KEY_SPACE)) {
                    thePlayer.fire();
                }

                if(input.isKeyDown(Input.KEY_LSHIFT)) {
                    thePlayer.boost();
                }

                if(input.isKeyDown(Input.KEY_LCONTROL)) {
                    thePlayer.brake();
                }
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        if(screen == null) {
            screen = new Screen(graphics);
            graphics.setAntiAlias(true);
        }

        if(world != null) {
            world.render(screen);
        }
    }

    public static void main(String args[]) throws SlickException {
        AppGameContainer container = new AppGameContainer(new SpaceGameApp());
        container.setDisplayMode(1024, 512, false);
        container.start();
    }
}
