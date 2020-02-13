package com.gerald.model;

public class PVector {
    private float x,y,z;


    public PVector(){
        x = 0; y = 0; z = 0;
    }
    public PVector(float x, float y) {
        this.x = x;
        this.y = y;
        z = 0;
    }

    public void mult(int m){
        x *= m;
        y *= m;
    }

    public PVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }
    public int getintX() {
        return (int)x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public int getintY() {
        return (int)y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }


}
