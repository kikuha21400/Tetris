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
        Engine mainEngine = new Engine();

        while (mainEngine.isRunning()){
        }
    }
}