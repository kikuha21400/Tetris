package org.empty.gamemaker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <h1> Scene interface</h1>
 * <p> represents scene with some stuff in it </p>
 * <p> scene can store graphic objects and draw them on the screen</p>
 */

public abstract class Scene{
    String name;
    Engine engine;

    ArrayList<GraphicObject> objects;


    protected Scene(String name, Engine engine){
        this.name = name;
        this.engine = engine;
        this.objects = new ArrayList<>();
        engine.addScene(this);

        initialize();
    }

    public String getName(){ return this.name;}

    public Engine getEngine(){ return this.engine;}

    public Iterator<GraphicObject> getObjects(){ return objects.iterator();}

    public void addObject(GraphicObject object){
        objects.add(object);
    }
    public GraphicObject getGraphicObject(String name) {
        Iterator<GraphicObject> objectsL = getObjects();
        while (objectsL.hasNext()){
            GraphicObject object = objectsL.next();
            if (object.getName().equals(name)){
                return object;
            }
        }

        return null;
    }

    public abstract void onRun();

    public abstract void initialize();

    public abstract void onTimer();


}