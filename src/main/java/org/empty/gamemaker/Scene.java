package org.empty.gamemaker;

import java.util.ArrayList;

/**
 * <h1> Scene interface</h1>
 * <p> represents scene with some stuff in it </p>
 * <p> scene can store graphic objects and draw them on the screen</p>
 */

class Scene{
    String name;
    Engine engine;

    ArrayList<GraphicObject> objects;

    Scene(String name, Engine engine){
        this.name = name;
        this.engine = engine;
    }
}