package org.empty.gamemaker.render;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import org.empty.gamemaker.GraphicObject;
import org.empty.gamemaker.Label;
import org.w3c.dom.Text;

import java.io.IOException;

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
        String outString = text.substring(0, sizeX - x + 1);

        textGraphics.setForegroundColor(foreground);
        textGraphics.setBackgroundColor(background);
        textGraphics.putString(y, x, outString);
    }

    public void render(GraphicObject object){
        if (object instanceof Label label){
            renderLabel(label.getPosX(),
                        label.getPosY(),
                        label.getSizeX(),
                        label.getText(),
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
            screen.stopScreen();
            screen.stopScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
