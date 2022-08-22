package org.empty;

import org.empty.gamemaker.*;
import org.empty.gamemaker.timer.Timer;
import org.empty.tetris.GameScene;

/**
 * <h1> Main class</h1>
 * <p> used to launch all screens, no multithreaded</p>
 */
public class LaunchApp {
    public static void main(String[] args) throws SceneNotFoundException {
        Engine mainEngine = new Engine();

        Timer timer = new Timer("Ticks", 1000 );

        Scene gameScene = new GameScene("gameScene", mainEngine);

        mainEngine.changeTo("gameScene");

        timer.start();

        try {
            while (mainEngine.isRunning()) {
                Scene activeScene = mainEngine.getActiveScene();
                mainEngine.render();
                activeScene.onRun();
                if (timer.getDone()){
                    mainEngine.getEngine().refresh();
                    activeScene.onTimer();
                    timer.refresh();
                }
            }
        } catch (NoActiveSceneException e){
            e.printStackTrace();
        }

        mainEngine.close();
        timer.stop();
    }
}