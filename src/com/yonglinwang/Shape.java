package com.yonglinwang;


import java.awt.Color;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;


public abstract class Shape {
	private Color color;
	private SecureRandom random = new SecureRandom();
	private String id;
	public Shape() {
		this(Color.black);
	}

	public Shape(Color color){
		this.color = color;
		id = new BigInteger(16, random).toString(16);
	}
	public Color getColor(){
		return color;
	}
	public void setColor(Color c){
		this.color = c;
	}
	public String getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
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

final class Rectangle extends Square{
	private static int numOfRect = 0;
	private int id;
	private double sideBravo;
	public Rectangle(double sideAlpha, double sideBravo, Color color){
		super(sideAlpha, color);
		this.sideBravo = sideBravo;
		numOfRect++;
		id = numOfRect;
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

	public static int getNumOfRectangles() {
		return numOfRect;
	}
	@Override
	public String toString() {
		return "Rectangle Number " + id + " of " + getNumOfRectangles() +". With the unique ID - " + getId() +" \nArea=" + findArea() + ", \nPerimeter="
				+ findPerimeter() + ", \nSideB=" + getSideBravo() + ", \nSideA=" + getSideAlpha()
				+ ", \nColor=" + getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sideBravo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(sideBravo) != Double.doubleToLongBits(other.sideBravo))
			return false;
		return true;
	}

}

class Square extends TwoDimensional{
	private static int numOfSquare = 0;
	private double sideAlpha;
	private int id;
	public Square(double sideAlpha, Color color){
		super(color);
		this.sideAlpha = sideAlpha;
		if (this.getClass() == Square.class) 
			numOfSquare++;
		id = numOfSquare;
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
		return "Square Number " + id + " of " + getNumOfSquare() + " has the unique ID - " + getId() + "\nArea=" + findArea() + ", \nPerimeter=" + findPerimeter()
		+ ", \nSide Length=" + getSideAlpha() + ", \nColor=" + getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sideAlpha);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		if (Double.doubleToLongBits(sideAlpha) != Double.doubleToLongBits(other.sideAlpha))
			return false;
		return true;
	}

}

class Rhombus extends Square{
	private static int numOfRhombus = 0;
	private double height;
	private int id;
	public Rhombus(double sideAlpha, double height, Color color){
		super(sideAlpha,color);
		this.height = height;
		if (this.getClass() == Rhombus.class)
			numOfRhombus++;
		id = numOfRhombus;
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
		return "Rhombus Number " + id + " of " + getNumOfRhombus() + " has the unique ID - " + getId() + " \nHeight=" + getHeight() + ", \nArea=" + findArea()
		+ ", \nPerimeter=" + findPerimeter() + ", Side Length=" + getSideAlpha()+ ", \nColor=" + getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rhombus other = (Rhombus) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}

}


class Parallelogram extends Rhombus{
	private static int numOfParallelograms = 0;
	private double sideBravo;
	private int id;
	public Parallelogram(double sideAlpha, double sideBravo, double height, Color color){
		super(sideAlpha,height,color);
		this.sideBravo = sideBravo;
		if (this.getClass() == IsoscelesTrapezoid.class)
			numOfParallelograms++;
		id = numOfParallelograms;
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
		return "Parallelogram Number " + id + " of " + getNumOfParallelograms() + " has the unique ID - " + getId() + ", \nSideB=" + getSideBravo() + ", \nPerimeter="
				+ findPerimeter() + ", \nHeight=" + getHeight() + ", \nArea=" + findArea() + ", \nSideA=" + getSideAlpha() + ", \nColor=" + getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sideBravo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parallelogram other = (Parallelogram) obj;
		if (Double.doubleToLongBits(sideBravo) != Double.doubleToLongBits(other.sideBravo))
			return false;
		return true;
	}

}

class IsoscelesTrapezoid extends Parallelogram{
	private static int numOfIsoscelesTrapezoid = 0;
	private double sideCharlie;
	private int id;
	public IsoscelesTrapezoid(double sideAlpha, double sideBravo, double sideCharlie, double height, Color color){
		super(sideAlpha, sideBravo, height, color);
		this.sideCharlie = sideCharlie;
		if (this.getClass() == IsoscelesTrapezoid.class)
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
		return "IsoscelesTrapezoid Number " + id + " of " + getNumOfIsoscelesTrapezoid() + " has the unique ID - " + getId() + "\nSideC=" + sideCharlie + ", \nPerimeter=" + findPerimeter() + ", \nArea=" + findArea() + ", \nSideB="
				+ getSideBravo() + ", \nHeight=" + getHeight() + ", \nSideA=" + getSideAlpha() + ", \ngetColor()=" + getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sideCharlie);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		IsoscelesTrapezoid other = (IsoscelesTrapezoid) obj;
		if (Double.doubleToLongBits(sideCharlie) != Double.doubleToLongBits(other.sideCharlie))
			return false;
		return true;
	}

}

final class Kite extends IsoscelesTrapezoid{
	private int id;
	private static int numOfKite = 0;
	private double sideBravo;
	public Kite(double sideAlpha, double sideBravo, double diagonalp, double diagonalq, Color color){
		super(sideAlpha,sideBravo,diagonalp,diagonalq,color);
		this.sideBravo = sideBravo;
		numOfKite++;
		id = numOfKite;
	}
	public Kite(){
		this(0,0,0,0,Color.black);
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
		return "Kite Number " + id + " of " + getNumOfKite() + " has the unique ID - " + getId() + "\nSideB=" + getSideBravo() + ", \nPerimeter="
				+ findPerimeter() + ", \nArea=" + findArea() + ", \nSideAlpha=" + getSideAlpha()
				+ ", \nColor=" + getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sideBravo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kite other = (Kite) obj;
		if (Double.doubleToLongBits(sideBravo) != Double.doubleToLongBits(other.sideBravo))
			return false;
		return true;
	}

}


class Cube extends ThreeDimensional{
	private static int numOfCubes = 0;
	private int id;
	private double sideAlpha;
	public Cube(double sideAlpha, Color color){
		super(color);
		this.sideAlpha = sideAlpha;
		if (this.getClass() == Cube.class)
			numOfCubes++;
		id = numOfCubes;
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
		return "Cube Number " + id + " of " + getNumOfCubes() + " has the unique ID - " + getId() + "\nSideAlpha=" + getSideAlpha() + ", \nSurface Area="
				+ findSurfaceArea() + ", \nVolume=" + findVolume() + ", \nColor=" + getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sideAlpha);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cube other = (Cube) obj;
		if (Double.doubleToLongBits(sideAlpha) != Double.doubleToLongBits(other.sideAlpha))
			return false;
		return true;
	}

}

class SquareBasedPrism extends Cube{
	private static int numOfSquareBasedPrism = 0;
	private double height;
	private int id;
	public SquareBasedPrism(double sideAlpha, double height, Color color){
		super(sideAlpha, color);
		this.height = height;
		if (this.getClass() == SquareBasedPrism.class)
			numOfSquareBasedPrism++;
		id = numOfSquareBasedPrism;
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

	public static int getNumOfSquareBasedPrism() {
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
		return "Square Based Prism Number " + id + " of " + getNumOfSquareBasedPrism() + " has the unique ID - " + getId() + "\nHeight=" + getHeight() + ", \nSurface Area="
				+ findSurfaceArea() + ", \nVolume=" + findVolume() + ", \nSideAlpha=" + getSideAlpha() + ", \nColor=" + getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareBasedPrism other = (SquareBasedPrism) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}

}

class RectangularPrism extends SquareBasedPrism{
	private static int numOfRectangularPrism = 0;
	private double sideBravo;
	private int id;
	public RectangularPrism(double sideAlpha, double sideBravo, double height, Color color){
		super(sideAlpha, height, color);
		this.sideBravo = sideBravo;
		if (this.getClass() == RectangularPrism.class)
			numOfRectangularPrism++;
		id = numOfRectangularPrism;
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
		return "RectangularPrism Number " + id + " of " + getNumOfRectangularPrism() + " has the unique ID - " + getId() + "\nSideBravo=" + getSideBravo() + ", \nVolume="
				+ findVolume() + ", \nSurfaceArea=" + findSurfaceArea() + ", \nHeight=" + getHeight() + ", \nSideAlpha=" + getSideAlpha() + ", \nColor="
				+ getColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sideBravo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RectangularPrism other = (RectangularPrism) obj;
		if (Double.doubleToLongBits(sideBravo) != Double.doubleToLongBits(other.sideBravo))
			return false;
		return true;
	}

}

class RegularPentagonalPyramid extends RectangularPrism{
	private static int numOfRegularPentagonalPyramid = 0;
	private int id;
	public RegularPentagonalPyramid(double sideAlpha, double sideBravo, double height, Color color) {
		super(sideAlpha, sideBravo, height, color);
		numOfRegularPentagonalPyramid++;
		id = numOfRegularPentagonalPyramid;
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
		return "Regular Pentagonal Pyramid Number " + id + " of " + getNumOfRegularPentagonalPyramid() + " has the unique ID - " + getId() + "\nVolume()=" + findVolume() + ", \nSurfaceArea=" + findSurfaceArea()
		+ ", \nSideBravo()=" + getSideBravo() + ", \nHeight=" + getHeight() + ", \nSideAlpha=" + getSideAlpha() + ", Color=" + getColor();
	}

}

