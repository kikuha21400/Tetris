package org.empty.gamemaker;


public class GraphicObject{
    int posX;
    int posY;
    int sizeX;
    int sizeY;

    String name;

    GraphicObject(int posX, int posY, int sizeX, int sizeY, String name, Scene scene){
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.name = name;
        scene.addObject(this);
    }

    public int getPosX(){ return posX;}

    public int getPosY(){ return posY;}

    public void setPosX(int posX){ this.posX = posX;}

    public void setPosY(int posY){ this.posY = posY;}

    public int getSizeX(){ return sizeX;}

    public int getSizeY(){ return sizeY;}

    public void setSizeX(int sizeX){ this.sizeX = sizeX;}

    public void setSizeY(int sizeY){ this.sizeY = sizeY;}

    public String getName(){ return name;}


}