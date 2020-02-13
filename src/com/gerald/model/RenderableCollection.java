package com.gerald.model;

import java.awt.*;
import java.util.ArrayList;

public class RenderableCollection implements Renderable{
    private ArrayList<Renderable> objects;

    public RenderableCollection() {
        objects = new ArrayList<>();
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }

    public void putObject(Renderable r){
        objects.add(r);
    }
    public void removeObject(Renderable r){
        objects.remove(r);
    }


}
