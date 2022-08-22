package org.empty.gamemaker;

import org.empty.gamemaker.render.RenderEngine;
import org.empty.gamemaker.render.TextRenderEngine;

import java.util.ArrayList;

public class Engine {

    RenderEngine renderEngine;
    Scene activeScene;
    ArrayList<Scene> scenes;

    Boolean toClose;

    public Engine() {
        activeScene = null;
        scenes = new ArrayList<>();
        renderEngine = new TextRenderEngine();
        renderEngine.initialize();
        toClose = false;
    }

    public void addScene(Scene scene){
        scenes.add(scene);
    }

    public void changeTo(String name) throws SceneNotFoundException {
        for (Scene scene:
             scenes) {
            if (scene.name.equals(name)){
                activeScene = scene;
                return;
            }
        }

        throw new SceneNotFoundException(name);
    }

    public void render() throws NoActiveSceneException {
        if (activeScene == null){
            throw new NoActiveSceneException();
        }

        getEngine().clear();
        for (GraphicObject object: activeScene.objects){
            renderEngine.render(object);
        }
    }

    public boolean isRunning(){
        return !toClose;
    }

    public void close(){
        renderEngine.close();
        toClose = true;
    }

    public Scene getScene(String name){
        for (Scene scene: scenes){
            if (scene.name.equals(name)){
                return scene;
            }
        }

        return null;
    }

    public RenderEngine getEngine(){return renderEngine;}

    public Scene getActiveScene(){
        return activeScene;
    }

}
