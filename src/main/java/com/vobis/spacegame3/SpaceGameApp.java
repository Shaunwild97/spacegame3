package com.vobis.spacegame3;

import com.vobis.spacegame3.entity.EntityAlly;
import com.vobis.spacegame3.entity.EntityEnemy;
import com.vobis.spacegame3.entity.EntityPlayer;
import com.vobis.spacegame3.game.Screen;
import com.vobis.spacegame3.game.World;
import com.vobis.spacegame3.game.camera.Camera;
import com.vobis.spacegame3.game.camera.TrackingCamera;
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
        gameContainer.setMinimumLogicUpdateInterval(GAME_TICK);
        INPUT = gameContainer.getInput();
        System.out.println("Game Started");

        screen = new Screen();

        world = new World();
        thePlayer = new EntityPlayer();
        thePlayer.getPos().set(512, 256);

        EntityAlly ally = new EntityAlly();
        ally.getPos().set(600, 256);
        world.add(ally);

        Camera camera = new TrackingCamera(thePlayer);
        screen.setCamera(camera);

        for (int i = 0; i < 5; i++) {
            EntityEnemy testEnemy = new EntityEnemy();
            testEnemy.getPos().set(i * 40, 256);
            world.add(testEnemy);
        }

        world.add(thePlayer);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        deltaCounter += delta;

        Input input = gameContainer.getInput();

        if (input.isKeyPressed(Input.KEY_1)) {
            DEBUG = !DEBUG;
            gameContainer.setShowFPS(DEBUG);
        }

        if (deltaCounter >= GAME_TICK) {
            deltaCounter = 0;

            if (world != null) {
                world.update();
            }
        }

        if(screen.isReady()) {
            screen.update();
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        if (!screen.isReady()) {
            screen.init(graphics);
        }

        if (world != null) {
            world.render(screen);
        }
    }

    public static void main(String args[]) throws SlickException {
        AppGameContainer container = new AppGameContainer(new SpaceGameApp());
        container.setDisplayMode(1024, 512, false);
        container.start();
    }
}
