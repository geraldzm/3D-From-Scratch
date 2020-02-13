package com.gerald.model;

import java.awt.*;
import java.util.ArrayList;

public class RenderAndTickCollection implements RenderAndTick{
    private ArrayList<RenderAndTick> objects;

    public RenderAndTickCollection() {
        objects = new ArrayList<>();
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }

    @Override
    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).tick();
        }
    }

    public void putObject(RenderAndTick r){
        objects.add(r);
    }

    public void removeObject(RenderAndTick r){
        objects.remove(r);
    }
}
