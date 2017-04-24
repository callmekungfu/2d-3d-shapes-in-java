package com.yonglinwang;

import java.awt.Color;

/**
 * Created by Yonglin Wang on 4/19/2017.
 */
public class Shapes {
    public static void main(String[] args){
        Rectangle rect = new Rectangle(10,10, Color.green);
        rect.setColor(Color.CYAN);
        System.out.println(rect.getWidth());
    }
}

class Rectangle extends TwoDimensional{
    private double width, length;
    public Rectangle(double width, double length, Color color){
        super(width*length, color,"Rectangle");
        this.width = width;
        this.length = length;
    }
    public Rectangle(){
        this(0,0,Color.BLACK);
    }
    public double getWidth(){
        return width;
    }
    public double getLength(){
        return length;
    }
    public void setWidth(double width){
        this.width = width;
        setArea(this.width, this.length);
    }
    public void setLength(double length){
        this.length = length;
        setArea(this.width, this.length);
    }
}

class Square extends TwoDimensional{
    private double sideLength;
    public Square(double sideLength, Color color){
        super(sideLength*sideLength, color, "Square");
        this.sideLength = sideLength;
    }
    public Square(){
        this(0, Color.black);
    }
    public double getSideLength(){
        return sideLength;
    }
    public void setSideLength(double sideLength){
        this.sideLength = sideLength;
        setArea(sideLength,sideLength);
    }

}

class Rhombus extends TwoDimensional{
    private double diagonalP, diagnoalQ;
    public Rhombus(double diagnoalQ, double diagonalP, Color color){
        super(diagnoalQ * diagonalP / 2, color,"Rhombus");
        this.diagnoalQ = diagnoalQ;
        this.diagonalP = diagonalP;
    }
}

class Trapezoid extends TwoDimensional{

}

class Kite extends TwoDimensional{

}

class parallelogram extends TwoDimensional{

}
