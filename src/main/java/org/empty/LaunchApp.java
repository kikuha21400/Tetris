package org.empty;

import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;

import java.io.IOException;

import org.empty.gamemaker.*;

/**
 * <h1> Main class</h1>
 * <p> used to launch all screens, no multithreaded</p>
 */
public class LaunchApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        DefaultTerminalFactory defFactory = new DefaultTerminalFactory();
        try (Screen screen = new TerminalScreen(defFactory.createTerminal())){
            screen.startScreen();
            Thread.sleep(2000);
            screen.stopScreen();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}