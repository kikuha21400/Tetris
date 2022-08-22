package org.empty.gamemaker;

public class AbstractTextObject extends GraphicObject {

    char [][] charMatrix;


    public AbstractTextObject(int posX, int posY, int sizeX, int sizeY, String name, Scene scene) {
        super(posX, posY, sizeX, sizeY, name, scene);
    }

    public void setCharMatrix(char [][] charMatrix){
        this.charMatrix = charMatrix.clone();
        System.arraycopy(charMatrix, 0, this.charMatrix, 0, charMatrix.length);
    }

    public char [][] getCharMatrix(){
        char [][] ret = this.charMatrix.clone();
        System.arraycopy(this.charMatrix, 0, ret, 0, this.charMatrix.length);
        return ret;
    }
}
