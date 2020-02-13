package com.gerald.model;

import java.awt.*;
import static java.lang.Math.*;
import static com.gerald.model.Matrix.*;

public class Rectangle3D extends Shape implements RenderAndTick {
    private PVector[] pVector = new PVector[8];
    private float angle;
   /* private float[][] projection = {
        {1,0,0},
        {0,1,0}
    };*/
    private float[][] rotationZ, rotationX, rotationY;

    public Rectangle3D(float x, float y) {
        super(x, y, 4);
        angle = 0;
        updateAngles();
        int l = 1;
        pVector[0] = new PVector(-l,-l, -l);
        pVector[1] = new PVector(l, -l, -l);
        pVector[2] = new PVector(l, l, -l );
        pVector[3] = new PVector(-l, l, -l);
        pVector[4] = new PVector(-l,-l, l);
        pVector[5] = new PVector(l, -l, l);
        pVector[6] = new PVector(l, l, l);
        pVector[7] = new PVector(-l, l, l);
    }

    @Override
    public void tick() {
        updateAngles();
        angle += 0.02;
    }
    private void updateAngles(){
        rotationZ = new float[][]{
                {(float) cos(angle), (float) -sin(angle), 0},
                {(float) sin(angle), (float) cos(angle), 0},
                {0, 0, 1}
        };
        rotationX = new float[][]{
                {1, 0, 0},
                {0, (float) cos(angle), (float) -sin(angle)},
                {0, (float) sin(angle), (float) cos(angle)}
        };
        rotationY = new float[][]{
                {(float) cos(angle), 0, (float) -sin(angle)},
                {0, 1, 0},
                {(float) sin(angle), 0, (float) cos(angle)}
        };
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        PVector [] projected = new PVector[8];
        for (int i = 0; i < pVector.length; i++) {
            PVector rotated = matMul(rotationY, pVector[i]);
            rotated = matMul(rotationX, rotated);
            rotated = matMul(rotationZ, rotated);

            //perspectiva
            float distance = 4;
            float z = 1/(distance - rotated.getZ());
            float[][] projection = {
                    {z,0,0},
                    {0,z,0}
            };

            PVector projected2d = matMul(projection, rotated);
            projected2d.mult(150);
            projected[i] = new PVector((int) (projected2d.getX() + x), (int) (projected2d.getY() + y));
            //g.fillOval(projected[i].getintX(), (int)projected[i].getintY(),  10, 10);
        }

        for (int i = 0; i < 4; i++) {
            connect(g, i, (i+1) % 4, projected);
            connect(g, i+4, ((i+1) % 4)+ 4, projected);
            connect(g, i, i+4, projected);
        }

    }

    private void connect(Graphics g, int i, int j, PVector[] p){
        g.drawLine(p[i].getintX(),p[i].getintY(), p[j].getintX(), p[j].getintY());
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
