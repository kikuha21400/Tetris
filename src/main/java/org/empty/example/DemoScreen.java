package org.empty.example;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import org.w3c.dom.Text;

import java.io.IOException;

public class DemoScreen {
    public static void main(String []args) throws InterruptedException {
        // Provide program the ability to define default terminal engine (swing, text, xterm ...)
        DefaultTerminalFactory defFactory = new DefaultTerminalFactory();
        // get screen object from terminal object (defFactory.createTerminal)
        try (Screen screen = defFactory.createScreen()){
            screen.startScreen();

            Thread.sleep(20000);

            screen.stopScreen();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
