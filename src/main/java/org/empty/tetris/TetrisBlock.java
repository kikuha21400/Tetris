package org.empty.tetris;

import org.empty.gamemaker.AbstractTextObject;
import org.empty.gamemaker.Scene;

public class TetrisBlock extends AbstractTextObject {
    char [][][] states;
    int state;
    int statesCount;


    public TetrisBlock(int posX, int posY, int sizeX, int sizeY, String name, Scene scene) {
        super(posX, posY, sizeX, sizeY, name, scene);
        this.state = 0;
    }

    public void rotate(){
        if (states != null) {
            this.setCharMatrix(states[++state % statesCount]);
        }
    }

    public void setStates(char [][][] states){
        this.states = states.clone();
        this.statesCount = states.length;
        System.arraycopy(states, 0, this.states, 0, states.length);
        this.setCharMatrix(states[state]);
    }
}
