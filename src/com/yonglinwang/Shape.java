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
    private double area;
    private String name;
    public TwoDimensional(double area, Color color, String name){
        super(color);
        this.name = name;
        setArea(area);
    }
    public TwoDimensional(){
        this(0, Color.black, "undefined");
    }
    public String getName(){
        return name;
    }
    public double getArea(){
        return area;
    }
    public void setArea(double width, double length){
        this.area = width*length;
    }
    public void setArea(double area){
        this.area = area;
    }
}

abstract class ThreeDimensional extends Shape{
    private double surfaceArea;
    private double volume;
    private String name;

    public ThreeDimensional(double surfaceArea, Color color, double volume, String name){
        super(color);
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }
    public double getVolume(){
        return volume;
    }
    public ThreeDimensional(){
        this(0, Color.black, 0,"undefined");
    }
    public String getName(){
        return name;
    }
    public double getSurfaceArea(){
        return surfaceArea;
    }
    public void setSurfaceArea(double surfaceArea){
        this.surfaceArea = surfaceArea;
    }
    public void setVolume(double volume){
        this.volume = volume;
    }
}