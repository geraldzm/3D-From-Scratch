package com.gerald.model;

import java.awt.*;

public abstract class ScreenObject implements Renderable {
    protected float x, y;

    public ScreenObject() {}

    public ScreenObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
}
