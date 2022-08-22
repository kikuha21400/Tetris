package org.empty.gamemaker.render;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import org.empty.gamemaker.AbstractTextObject;
import org.empty.gamemaker.GraphicObject;
import org.empty.gamemaker.Label;

import java.io.IOException;

import static java.lang.Math.min;

public class TextRenderEngine implements RenderEngine{

    Screen screen;
    TextGraphics textGraphics;

    public void initialize(){
        try {
            screen = new DefaultTerminalFactory().createScreen();
            screen.clear();
            screen.startScreen();
            screen.setCursorPosition(null);
            textGraphics = screen.newTextGraphics();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void renderLabel(int x, int y, int sizeX, String text, TextColor background, TextColor foreground){
        String outString = text.substring(0, min(sizeX - x + 1, text.length()));

        textGraphics.setForegroundColor(foreground);
        textGraphics.setBackgroundColor(background);
        textGraphics.putString(x, y, outString);
    }

    private void renderAbstract(int x, int y, int sizeX, int sizeY, char[][] charMap, TextColor background, TextColor foreground){
        for (int i = x; i < min(x + sizeX, y + charMap.length); ++i){
            for (int j = y; j < min(y + sizeY, y + charMap[0].length); ++j){
                if (charMap[j - y][i - x] != '.') {
                    screen.setCharacter(i, j, new TextCharacter(charMap[j - y][i - x], foreground, background));
                }
            }
        }
    }

    public void render(GraphicObject object){
        if (object instanceof Label label){
            renderLabel(label.getPosX(),
                        label.getPosY(),
                        label.getSizeX(),
                        label.getText(),
                        TextColor.ANSI.WHITE,
                        TextColor.ANSI.BLACK);
        } else if (object instanceof AbstractTextObject abstractTextObject){
            renderAbstract( abstractTextObject.getPosX(),
                            abstractTextObject.getPosY(),
                            abstractTextObject.getSizeX(),
                            abstractTextObject.getSizeY(),
                            abstractTextObject.getCharMatrix(),
                            TextColor.ANSI.WHITE,
                            TextColor.ANSI.BLACK);
        }
    }

    public void refresh(){
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            if (screen != null) {
                screen.stopScreen();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear(){
        screen.clear();
    }
}
