package org.empty.tetris;

import org.empty.gamemaker.Engine;
import org.empty.gamemaker.Scene;

public class GameScene extends Scene {

    TetrisBlock exampleBlock;
    public GameScene(String name, Engine engine) {
        super(name, engine);
    }

    public void onRun(){
        //TODO create game logic
    }

    public void onTimer(){
        //TODO things on 1 sec delay
        exampleBlock.setPosY(exampleBlock.getPosY() + 1);
        exampleBlock.setPosX(exampleBlock.getPosX() + 1);
        exampleBlock.rotate();
    }

    public void initialize(){
        // TODO create elements
        exampleBlock = new TetrisBlock(0, 0,  3, 3, "exampleBlock1", this);
        exampleBlock.setStates(new char[][][]{
                {
                        {'#', '.', '.'},
                        {'#', '.', '.'},
                        {'#', '.', '.'}
                },
                {
                        {'#', '#', '#'},
                        {'.', '.', '.'},
                        {'.', '.', '.'}
                }
        });
    }


}
