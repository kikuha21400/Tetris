package org.empty.gamemaker.timer;

public class Timer implements Runnable{
    private final double tickLength;
    Thread mainThread;
    String name;

    long lastTime;

    long curTime;
    boolean running;
    boolean done;

    public Timer(String name, double interval){
        mainThread = new Thread(this, "Timer " + name);
        this.name = name;
        this.tickLength = interval;
        this.done = false;
        this.running = false;
    }

    public void start(){
        this.running = true;
        this.lastTime = System.currentTimeMillis();
        mainThread.start();
    }

    public void run(){
        while(running){
            synchronized (this) {
                curTime = System.currentTimeMillis();

                if (curTime - lastTime >= tickLength) {
                    done = true;
                }
            }
        }
    }

    public synchronized void refresh(){
       done = false;
       lastTime = System.currentTimeMillis();
    }

    public synchronized boolean getDone(){
        return done;
    }

    public void stop(){
        running = false;
    }
}
