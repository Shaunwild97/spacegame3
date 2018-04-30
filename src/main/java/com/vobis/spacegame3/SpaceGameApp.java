package com.vobis.spacegame3;

import com.vobis.spacegame3.entity.EntityEnemy;
import com.vobis.spacegame3.entity.EntityPlayer;
import com.vobis.spacegame3.game.World;
import com.vobis.spacegame3.game.Screen;
import org.newdawn.slick.*;

public class SpaceGameApp extends BasicGame {

    public static boolean DEBUG = true;
    public static Input INPUT;

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
        INPUT = gameContainer.getInput();
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

        Input input = gameContainer.getInput();

        if(input.isKeyPressed(Input.KEY_1)) {
            DEBUG = !DEBUG;
            gameContainer.setShowFPS(DEBUG);
        }

        if (deltaCounter >= GAME_TICK) {
            deltaCounter = 0;

            if (world != null) {
                world.update();
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
