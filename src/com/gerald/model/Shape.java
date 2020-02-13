package com.gerald.model;

import java.awt.*;

public abstract class Shape extends ScreenObject {
    protected int sides;
    protected Color color;

    public Shape(float x, float y, int sides) {
        super(x, y);
        this.sides = sides;
    }

    public Shape(float x, float y) {
        super(x, y);
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public abstract void render(Graphics g);

    @Override
    public abstract Rectangle getBounds();
}
