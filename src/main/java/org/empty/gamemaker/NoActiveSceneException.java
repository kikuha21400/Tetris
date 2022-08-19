package org.empty.gamemaker;

public class NoActiveSceneException extends Exception{
    NoActiveSceneException(){
        super("No active scene found in Engine, abort execution");
    }

}
