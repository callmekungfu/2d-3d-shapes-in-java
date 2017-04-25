package com.yonglinwang;

import java.awt.Color;
import java.util.Arrays;

/**
 * Created by Yonglin Wang on 4/19/2017.
 */
public class Shapes {
    public static void main(String[] args){
    	Rectangle rect = new Rectangle(10,15,Color.CYAN);
    	System.out.println(rect);
    }
}

class Rectangle extends Square{
    private static int numOfRect = 0;
    private double sideBravo;
    public Rectangle(double sideAlpha, double sideBravo, Color color){
        super(sideAlpha, color);
        this.sideBravo = sideBravo;
        numOfRect++;
    }
    public Rectangle(){
        this(0,0, Color.black);
    }

    @Override
    public double findArea() {
        return sideBravo * getSideAlpha();
    }

    @Override
    public double findPerimeter() {
        return 2 * sideBravo + 2 * getSideAlpha();
    }

    public void setSideBravo(double sideBravo) {
        this.sideBravo = sideBravo;
    }

    public double getSideBravo() {
        return sideBravo;
    }

    public static int getNumOfRect() {
        return numOfRect;
    }
	@Override
	public String toString() {
		return "Rectangle [sideBravo=" + sideBravo + ", findArea()=" + findArea() + ", findPerimeter()="
				+ findPerimeter() + ", getSideBravo()=" + getSideBravo() + ", getSideAlpha()=" + getSideAlpha()
				+ ", getColor()=" + getColor() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
}

class Square extends TwoDimensional{
    private static int numOfSquare = 0;
    private double sideAlpha;
    public Square(double sideAlpha, Color color){
        super(color);
        this.sideAlpha = sideAlpha;
        numOfSquare++;
    }
    public Square(){
        this(0, Color.black);
    }
    @Override
    public double findArea() {
        return sideAlpha * sideAlpha;
    }
    @Override
    public double findPerimeter() {
        return 4 * sideAlpha;
    }
    public double getSideAlpha(){
        return sideAlpha;
    }
    public void setSideAlpha(double sideAlpha){
        this.sideAlpha = sideAlpha;
    }
    public static int getNumOfSquare() {
		return numOfSquare;
	}
	@Override
	public String toString() {
		return "Square [sideAlpha=" + sideAlpha + ", findArea()=" + findArea() + ", findPerimeter()=" + findPerimeter()
				+ ", getSideAlpha()=" + getSideAlpha() + ", getColor()=" + getColor() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}

class Rhombus extends Square{
    private static int numOfRhombus = 0;
    private double height;
    public Rhombus(double sideAlpha, double height, Color color){
        super(sideAlpha,color);
        this.height = height;
        numOfRhombus++;
    }
    public Rhombus(){
        this(0,0, Color.black);
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public static int getNumOfRhombus() {
        return numOfRhombus;
    }

    @Override
    public double findArea() {
        return getSideAlpha() * getHeight();
    }
	@Override
	public String toString() {
		return "Rhombus [height=" + height + ", getHeight()=" + getHeight() + ", findArea()=" + findArea()
				+ ", findPerimeter()=" + findPerimeter() + ", getSideAlpha()=" + getSideAlpha() + ", toString()="
				+ super.toString() + ", getColor()=" + getColor() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
    
}

class IsoscelesTrapezoid extends Parallelogram{
    private static int numOfIsoscelesTrapezoid = 0;
    private double sideCharlie;
    public IsoscelesTrapezoid(double sideAlpha, double sideBravo, double sideCharlie, double height, Color color){
        super(sideAlpha, sideBravo, height, color);
        this.sideCharlie = sideCharlie;
        numOfIsoscelesTrapezoid++;
    }
    public IsoscelesTrapezoid(){
        this(0,0,0,0,Color.black);
    }

    public void setSideCharlie(double sideCharlie) {
        this.sideCharlie = sideCharlie;
    }

    public double getSideCharlie() {
        return sideCharlie;
    }

    public static int getNumOfIsoscelesTrapezoid() {
        return numOfIsoscelesTrapezoid;
    }

    @Override
    public double findPerimeter() {
        return getSideAlpha() + getSideBravo() + 2 * getSideCharlie();
    }

    @Override
    public double findArea() {
        return (getSideAlpha() + getSideBravo()) / 2 * getHeight();
    }
	@Override
	public String toString() {
		return "IsoscelesTrapezoid [sideCharlie=" + sideCharlie + ", getSideCharlie()=" + getSideCharlie()
				+ ", findPerimeter()=" + findPerimeter() + ", findArea()=" + findArea() + ", getSideBravo()="
				+ getSideBravo() + ", getHeight()=" + getHeight() + ", toString()=" + super.toString()
				+ ", getSideAlpha()=" + getSideAlpha() + ", getColor()=" + getColor() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
    
}

class Kite extends Square{
    private static int numOfKite = 0;
    private double sideBravo;
    public Kite(double sideAlpha, double sideBravo, Color color){
        super(sideAlpha,color);
        this.sideBravo = sideBravo;
        numOfKite++;
    }
    public Kite(){
        this(0,0,Color.black);
    }

    public void setSideBravo(double sideBravo) {
        this.sideBravo = sideBravo;
    }

    public double getSideBravo() {
        return sideBravo;
    }

    public static int getNumOfKite() {
        return numOfKite;
    }

    @Override
    public double findPerimeter() {
        return 2 * (getSideAlpha() * getSideBravo());
    }
	@Override
	public String toString() {
		return "Kite [sideBravo=" + sideBravo + ", getSideBravo()=" + getSideBravo() + ", findPerimeter()="
				+ findPerimeter() + ", findArea()=" + findArea() + ", getSideAlpha()=" + getSideAlpha()
				+ ", toString()=" + super.toString() + ", getColor()=" + getColor() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
    
}

class Parallelogram extends Rhombus{
    private static int numOfParallelograms = 0;
    private double sideBravo;
    public Parallelogram(double sideAlpha, double sideBravo, double height, Color color){
        super(sideAlpha,height,color);
        this.sideBravo = sideBravo;
        numOfParallelograms++;
    }
    public Parallelogram(){
        this(0,0,0, Color.black);
    }

    public void setSideBravo(double sideBravo) {
        this.sideBravo = sideBravo;
    }

    public double getSideBravo() {
        return sideBravo;
    }

    public static int getNumOfParallelograms() {
        return numOfParallelograms;
    }

    @Override
    public double findPerimeter() {
        return 2 * getSideAlpha() * 2 * getSideBravo();
    }
	@Override
	public String toString() {
		return "Parallelogram [sideBravo=" + sideBravo + ", getSideBravo()=" + getSideBravo() + ", findPerimeter()="
				+ findPerimeter() + ", getHeight()=" + getHeight() + ", findArea()=" + findArea() + ", toString()="
				+ super.toString() + ", getSideAlpha()=" + getSideAlpha() + ", getColor()=" + getColor()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
}

class IrregularTrapezoid extends IsoscelesTrapezoid{
    private static int numOfIrregularTrapezoid = 0;
    private double sideDelta;
    public IrregularTrapezoid(double sideAlpha, double sideBravo, double sideCharlie, double sideDelta, Color color){
        super(sideAlpha,sideBravo,sideCharlie,-1,color);
        this.sideDelta = sideDelta;
        numOfIrregularTrapezoid++;
    }

    public double getSideDelta() {
        return sideDelta;
    }

    public void setSideDelta(double sideDelta) {
        this.sideDelta = sideDelta;
    }

    public static int getNumOfIrregularTrapezoid() {
        return numOfIrregularTrapezoid;
    }

    @Override
    public double findPerimeter() {
        return getSideAlpha()+getSideBravo()+getSideCharlie()+getSideDelta();
    }

    @Override
    public double findArea() {
        System.err.println("The program currently cannot find the area of an irregular polygon. -1 is returned.");
        return -1;
    }

	@Override
	public String toString() {
		return "IrregularTrapezoid [sideDelta=" + sideDelta + ", getSideDelta()=" + getSideDelta()
				+ ", findPerimeter()=" + findPerimeter() + ", findArea()=" + findArea() + ", getSideCharlie()="
				+ getSideCharlie() + ", toString()=" + super.toString() + ", getSideBravo()=" + getSideBravo()
				+ ", getHeight()=" + getHeight() + ", getSideAlpha()=" + getSideAlpha() + ", getColor()=" + getColor()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
}

class Cube extends ThreeDimensional{
    private static int numOfCubes = 0;
    private double sideAlpha;
    public Cube(double sideAlpha, Color color){
        super(color);
        this.sideAlpha = sideAlpha;
        numOfCubes++;
    }
    public Cube(){
        this(0, Color.black);
    }

    public void setSideAlpha(double sideAlpha) {
        this.sideAlpha = sideAlpha;
    }

    public double getSideAlpha() {
        return sideAlpha;
    }

    public static int getNumOfCubes() {
        return numOfCubes;
    }

    @Override
    public double findSurfaceArea() {
        return getSideAlpha() * getSideAlpha() * 6;
    }

    @Override
    public double findVolume() {
        return getSideAlpha() * getSideAlpha() * getSideAlpha();
    }
	@Override
	public String toString() {
		return "Cube [sideAlpha=" + sideAlpha + ", getSideAlpha()=" + getSideAlpha() + ", findSurfaceArea()="
				+ findSurfaceArea() + ", findVolume()=" + findVolume() + ", getColor()=" + getColor() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}

class SquareBasedPrism extends Cube{
    private static int numOfSquareBasedPrism = 0;
    private double height;
    public SquareBasedPrism(double sideAlpha, double height, Color color){
        super(sideAlpha, color);
        this.height = height;
        numOfSquareBasedPrism++;
    }
    public SquareBasedPrism(){
        this(0,0,Color.black);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static int count() {
        return numOfSquareBasedPrism;
    }

    @Override
    public double findSurfaceArea() {
        return 2 * (getSideAlpha() * getSideAlpha()) + 4 * (getSideAlpha() * getHeight());
    }

    @Override
    public double findVolume() {
        return (getSideAlpha()*getSideAlpha()) * getHeight();
    }
	@Override
	public String toString() {
		return "SquareBasedPrism [height=" + height + ", getHeight()=" + getHeight() + ", findSurfaceArea()="
				+ findSurfaceArea() + ", findVolume()=" + findVolume() + ", getSideAlpha()=" + getSideAlpha()
				+ ", toString()=" + super.toString() + ", getColor()=" + getColor() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
    
}

class RectangularPrism extends SquareBasedPrism{
    private static int numOfRectangularPrism = 0;
    private double sideBravo;
    public RectangularPrism(double sideAlpha, double sideBravo, double height, Color color){
        super(sideAlpha, height, color);
        this.sideBravo = sideBravo;
        numOfRectangularPrism++;
    }
    public RectangularPrism(){
        this(0,0,0,Color.black);
    }

    public double getSideBravo() {
        return sideBravo;
    }

    public void setSideBravo(double sideBravo) {
        this.sideBravo = sideBravo;
    }

    public static int getNumOfRectangularPrism() {
        return numOfRectangularPrism;
    }

    @Override
    public double findVolume() {
        return getSideAlpha() * getSideBravo() * getHeight();
    }

    @Override
    public double findSurfaceArea() {
        return getSideAlpha() * getSideBravo() * 2 + getHeight() * getSideAlpha() * 2 + getHeight() * getSideBravo() * 2;
    }
	@Override
	public String toString() {
		return "RectangularPrism [sideBravo=" + sideBravo + ", getSideBravo()=" + getSideBravo() + ", findVolume()="
				+ findVolume() + ", findSurfaceArea()=" + findSurfaceArea() + ", getHeight()=" + getHeight()
				+ ", toString()=" + super.toString() + ", getSideAlpha()=" + getSideAlpha() + ", getColor()="
				+ getColor() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
}

class RegularPentagonalPyramid extends RectangularPrism{
    private static int numOfRegularPentagonalPyramid = 0;
    public RegularPentagonalPyramid(double sideAlpha, double sideBravo, double height, Color color) {
        super(sideAlpha, sideBravo, height, color);
        numOfRegularPentagonalPyramid++;
    }

    public static int getNumOfRegularPentagonalPyramid() {
        return numOfRegularPentagonalPyramid;
    }

    @Override
    public double findVolume() {
        return 5 / 12 * Math.tan(54) * getHeight() * (getSideAlpha() * getSideAlpha());
    }

    @Override
    public double findSurfaceArea() {
        return 1.25 * Math.tan(54) * (getSideAlpha() * getSideAlpha()) + 5 * (getSideAlpha() / 2) * Math.sqrt((getHeight() * getHeight())+((getSideAlpha()*Math.tan(54)/2)*(getSideAlpha()*Math.tan(54)/2)));
    }

	@Override
	public String toString() {
		return "RegularPentagonalPyramid [findVolume()=" + findVolume() + ", findSurfaceArea()=" + findSurfaceArea()
				+ ", getSideBravo()=" + getSideBravo() + ", toString()=" + super.toString() + ", getHeight()="
				+ getHeight() + ", getSideAlpha()=" + getSideAlpha() + ", getColor()=" + getColor() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
}

class IrregularPentagonalPyramid extends RectangularPrism{
    private static int numOfIrregularPentagonalPyramid = 0;
    private double[] sideLengths;
    public IrregularPentagonalPyramid(double[] sideLengths){
    	sideLengths = new double[10];
    	for (int i = 0; i < sideLengths.length; i++) {
			this.sideLengths[i] = sideLengths[i];
		}
    	numOfIrregularPentagonalPyramid++;
    }
    public double[] getSideLengths() {
		return sideLengths;
	}
    public void setSideLengths(double[] sideLengths) {
		this.sideLengths = sideLengths;
	}
    public static int getNumOfIrregularPentagonalPyramid() {
		return numOfIrregularPentagonalPyramid;
	}
    @Override
    public double findSurfaceArea() {
    	System.err.println("This program does not support calculation of the irregular pentagonal pyramid surface area.");
    	return -1;
    }
    @Override
    public double findVolume() {
    	System.err.println("This program does not support calculation of the irregular pentagonal pyramid volume.");
    	return -1;
    }
	@Override
	public String toString() {
		return "IrregularPentagonalPyramid [sideLengths=" + Arrays.toString(sideLengths) + ", getSideLengths()="
				+ Arrays.toString(getSideLengths()) + ", findSurfaceArea()=" + findSurfaceArea() + ", findVolume()="
				+ findVolume() + ", getSideBravo()=" + getSideBravo() + ", toString()=" + super.toString()
				+ ", getHeight()=" + getHeight() + ", getSideAlpha()=" + getSideAlpha() + ", getColor()=" + getColor()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    

}
