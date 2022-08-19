package org.empty.gamemaker;

public class SceneNotFoundException extends Exception{
    SceneNotFoundException(String name){
        super("No scene with name " + name);
    }

}
