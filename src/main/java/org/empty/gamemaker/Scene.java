package org.empty.gamemaker;

/**
 * <h1> Scene interface</h1>
 * <p> represents scene with some stuff in it </p>
 * <p> scene can store graphic objects and draw them on the screen</p>
 */

public abstract class Scene {

    public abstract void drawScene();

    public abstract void addGraphic(GraphicObject graphicObject, int x, int y);

}
