package org.empty.gamemaker;

import com.googlecode.lanterna.TextColor;

public class Label extends GraphicObject{
    String text;
    TextColor foreground;
    TextColor background;

    public Label(int posX, int posY, int sizeX, String name, String text, Scene scene){
        super(posX, posY, sizeX, 1, name, scene);
        this.text = text;
    }

    public String getText(){ return text;}

    public void setText(String text){ this.text = text;}
}
