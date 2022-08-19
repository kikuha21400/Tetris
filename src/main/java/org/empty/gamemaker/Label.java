package org.empty.gamemaker;

public class Label extends GraphicObject{
    String text;

    Label(String text){
        this.text = text;
    }

    public String getText(){ return text;}

    public void setText(String text){ this.text = text;}
}
