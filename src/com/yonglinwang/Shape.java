package com.yonglinwang;

/**
 * Created by Yonglin Wang on 4/19/2017.
 */
import java.awt.Color;

public abstract class Shape {
    private Color color;

    public Shape() {
        this(Color.black);
    }

    public Shape(Color color){
        this.color = color;

    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color c){
        this.color = c;
    }
}

abstract class TwoDimensional extends Shape{
    private static int numOfTwoD = 0;
    public TwoDimensional(Color color){
        super(color);
        numOfTwoD++;
    }
    public TwoDimensional(){
        this(Color.black);
    }
    public abstract double findArea();
    public abstract double findPerimeter();

    public static int getNumOfTwoD() {
        return numOfTwoD;
    }
}

abstract class ThreeDimensional extends Shape{
    private static int numOfThreeD = 0;


    public ThreeDimensional(Color color){
        super(color);
    }

    public ThreeDimensional(){
        this(Color.black);
    }

    public static int getNumOfThreeD() {
        return numOfThreeD;
    }

    public abstract double findSurfaceArea();
    public abstract double findVolume();
}