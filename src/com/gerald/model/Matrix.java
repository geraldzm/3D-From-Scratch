package com.gerald.model;

public class Matrix {

    public static PVector matMul(float[][]a, PVector p){
        return matrixToVec(matMul(a, vectoMatrix(p)));
    }
    public static float[][] matMul(float[][]a, float[][]b){
        int colsA = a[0].length;
        int rowsA = a.length;
        int colsB = b[0].length;
        int rowsB = b.length;
        if(colsA != rowsB){
            System.out.println("Columns of A must match rows of B");
            return null;
        }
        float result [][] = new float[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                float sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static float[][] vectoMatrix(PVector p){
        float[][]m = new float[3][1];
        m[0][0] = p.getX();
        m[1][0] = p.getY();
        m[2][0] = p.getZ();
        return m;
    }

    public static PVector matrixToVec(float [][]m){
        PVector v = new PVector();
        v.setX(m[0][0]);
        v.setY(m[1][0]);
        if(m.length > 2)v.setZ(m[2][0]);
        return v;
    }
}
