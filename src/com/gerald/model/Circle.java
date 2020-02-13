package com.gerald.model;

import java.awt.*;

public class Circle extends Shape {
    private int radio;

    public Circle(float x, float y, int radio) {
        super(x, y, 0);
        this.radio = radio;
        setX(this.x);
        setX(this.y);
        color = Color.GREEN;
    }


    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x, (int)y,radio,radio);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void setX(float x) {
        super.setX(x - radio);
    }

    @Override
    public void setY(float y) {
        super.setY(y - radio);
    }
}
