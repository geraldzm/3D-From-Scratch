package com.gerald.model;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable{
    public static final int WIDTH = 940, HEIGHT = WIDTH / 12* 9;
    private Thread thread;
    private boolean running = false;
    private RenderAndTickCollection renCollection;

    Main(){
        /*
        * solo falta conectar los puntos :') voy a llorar. THIS IS FUCKING AMAZING!!!
        * */
        new com.gerald.view.Window(WIDTH, HEIGHT, "3D", this);
        renCollection = new RenderAndTickCollection();
        renCollection.putObject(new Rectangle3D(400,300));
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            boolean shouldRender = false;
            while(delta >=1) {
                tick();
                delta--;
                shouldRender = true;
            }
            if(shouldRender) {
                render();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);

        renCollection.render(g);

        g.dispose();
        bs.show();
    }

    private void tick() {
        renCollection.tick();
    }

    public static void main(String[] args) {
        new Main();
    }
}
