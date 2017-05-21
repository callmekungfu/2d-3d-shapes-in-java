package com.yonglinwang;


import java.awt.Color;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * <pre>The abstract root class of all shapes</pre>
 *
 * <h2>Class Explanation</h2>
 * <p>
 *		Abstract class for documenting 2-dimensional or 3-dimensional shapes in YonglinDB.
 *		The class does not contain any abstract methods that have to be overridden by subclasses
 *		however, it is encouraged to overwrite the methods that are related to ID generation.
 * </p>
 * <p>
 * 		The unique ID generation tool is specially designed to avoid repetition and preserve
 * 		expandability. The class utilizes a secure random seed to generate a hexadecimal version
 * 		of a big integer, then convert it to a String through radix 16.
 * </p>
 * <p>
 * 		This class also uses a hash code/equals method generated by Eclipse to prevent human errors
 * 		from occurring when creating this method.
 * </p>
 * @author Yonglin Wang
 * @version 1.1
 *
 * @see java.math.BigInteger
 * @see java.security.SecureRandom
 */
public abstract class Shape {
	/**
	 * The user defined color.
	 */
	private Color color;
	/**
	 * An encrypted random seed that is used for generating unique ID.
	 */
	private SecureRandom random = new SecureRandom();
	/**
	 * The unique Identification of this object
	 */
	private String id;
	/**
	 * Default constructor of creating shapes. This constructor is called when
	 * subclasses does not provide a color for rendering of the object(shape).
	 */
	public Shape() {
		this(Color.black);
	}

	/**
	 * Creates a new Shape with a randomly defined unique ID and a user defined color
	 * 
	 * @param color A java awt color that the shape will be rendered in.
	 */
	public Shape(Color color){
		this.color = color;
		id = new BigInteger(16, random).toString(16);
	}
	/**
	 * This method is used when programmer needs to access the color of a shape.
	 * 
	 * @return The color that the shape will be rendered in
	 */
	public Color getColor(){
		return color;
	}
	/**
	 * Modifies the color of the shape object.
	 * 
	 * @param c The color to render the shape in.
	 */
	public void setColor(Color c){
		this.color = c;
	}
	/**
	 * @return The unique identification of the shape in String.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id The new identification for the shape in string.
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

/**
 * <pre>An abstract class that implements 2-dimensional shapes</pre>
 * <h2>Class Explanation</h2>
 * <p>
 * 		Abstract class for recording 2-dimensional shapes for YonglinDB. The only methods required
 * 		to be overridden are findArea() and findPerimeter() since most shapes calculate those properties
 * 		differently. It is recommended to not override any other methods in this class.
 * </p>
 * <p>
 * 		The default constructor of this class renders the shape black. User is able to define a new color
 * 		for the shapes created.
 * </p>
 * @author Yonglin Wang
 * @version 1.1
 *
 * @see com.yonglinwang.Shape
 */
abstract class TwoDimensional extends Shape{
	/**
	 * A static variable that stores the number of two dimensional shapes created.
	 */
	private static int numOfTwoD = 0;

	/**
	 * Constructs a TwoDimensional shape with a user defined color.
	 * @param color A java awt color that the shape will be rendered in.
	 */
	public TwoDimensional(Color color){
		super(color);
		numOfTwoD++;
	}

	/**
	 * Default constructor, constructs a black TwoDimensional shape.
	 */
	public TwoDimensional(){
		this(Color.black);
	}

	/**
	 * <pre>Calculate the area of a two dimensional shape</pre>
	 * <p>
	 *     This method is defined abstract in the TwoDimensional Class. For detailed processing documentation
	 *     please refer to inherited subclasses.
	 * </p>
	 * @return The calculated area of the shape
	 */
	public abstract double findArea();

	/**
	 * <pre>Calculate the perimeter of a two dimensional shape</pre>
	 * <p>
	 *     This method is defined abstract in the TwoDimensional Class. For detailed processing documentation
	 *     please refer to inherited subclasses.
	 * </p>
	 * @return The calculated perimeter of the shape
	 */
	public abstract double findPerimeter();

	/**
	 * <pre>Obtain the number of two dimensional shapes created</pre>
	 * <h2>Method Explanation</h2>
	 * <p>
	 *     This method serves the same purpose as the page counter in Office Word. The class variable is incremented
	 *     whenever the constructor is called. Which could be accessed through this method.
	 * </p>
	 * @return An integer containing the number of two dimensional shapes created
	 */
	public static int getNumOfTwoD() {
		return numOfTwoD;
	}

}

/**
 * <pre>An abstract class that implements 3-dimensional shapes</pre>
 * <h2>Class Explanation</h2>
 * <p>
 * 		Abstract class for recording 3-dimensional shapes for YonglinDB. The only methods required
 * 		to be overridden are findSurfaceArea() and findVolume() since most shapes calculate those properties
 * 		differently. It is recommended to not override any other methods in this class.
 * </p>
 * <p>
 * 		The default constructor of this class renders the shape black. User is able to define a new color
 * 		for the shapes created.
 * </p>
 * @author Yonglin Wang
 * @version 1.1
 *
 * @see com.yonglinwang.Shape
 */
abstract class ThreeDimensional extends Shape{
	/**
	 *
	 */
	private static int numOfThreeD = 0;

	/**
	 * Constructs a ThreeDimensional shape with user defined Java AWT color
	 * @param color A java awt color that the shape will be rendered in.
	 */
	public ThreeDimensional(Color color){
		super(color);
		numOfThreeD++;
	}
	/**
	 * Default Constructor that creates a black ThreeDimensional Shape.
	 */
	public ThreeDimensional(){
		this(Color.black);
	}

	/**
	 * <pre>Obtain the number of three dimensional shapes created</pre>
	 * <h2>Method Explanation</h2>
	 * <p>
	 *     This method serves the same purpose as the page counter in Office Word. The class variable is incremented
	 *     whenever the constructor is called. Which could be accessed through this method.
	 * </p>
	 * @return An integer containing the number of three dimensional shapes created
	 */
	public static int getNumOfThreeD() {
		return numOfThreeD;
	}

	/**
	 * <pre>Calculate the surface area of a three dimensional shape</pre>
	 * <p>
	 *     This method is defined abstract in the ThreeDimensional Class. For detailed processing documentation
	 *     please refer to inherited subclasses.
	 * </p>
	 * @return The calculated surface area of the shape
	 */
	public abstract double findSurfaceArea();
	/**
	 * <pre>Calculate the volume of a three dimensional shape</pre>
	 * <p>
	 *     This method is defined abstract in the ThreeDimensional Class. For detailed processing documentation
	 *     please refer to inherited subclasses.
	 * </p>
	 * @return The calculated volume of the shape
	 */
	public abstract double findVolume();
}

/**
 * <pre>Concrete implementation of a rectangle in YonglinDB</pre>
 * <h2>Class Explanation</h2>
 * <p>
 *     Inheritable, instantiable class that implements the properties and functionality of a rectangle for YonglinDB.
 *     The Rectangle object can be instantiated with three vital pieces of information - length of side A, length of
 *     side B, and the color of the shape.
 * </p>
 * <p>
 *     The rectangle class directly inherits its properties from the Square object to minimize the amount of properties
 *     needed to be created. This is required for this programming task as its purpose is to demonstrate object orientation
 *     programming concepts such as polymorphism learned in class.
 * </p>
 * <p>
 *     The objects contain an array of behaviors that enables users to document rectangle shapes in YonglinDB, including
 *     accessors and modifier of properties. Proper toString, hashcode, and equals method.
 * </p>
 *
 * @author Yonglin Wang
 * @version 1.2
 *
 * @see com.yonglinwang.Shape
 * @see com.yonglinwang.Square
 * @see com.yonglinwang.TwoDimensional
 */
final class Rectangle extends Square{
	/**
	 * Class level variable that hosts the total number of Rectangles created.
	 */
	private static int numOfRect = 0;
	/**
	 * Unique identification digit of this rectangle for shape counting feature.
	 */
	private int id;
	/**
	 * The value of the second side length of the rectangle.
	 */
	private double sideBravo;

	/**
	 * Constructs a rectangle object by calling the parent constructor, instantiating the instance variables, increment
	 * the class level counter by one.
	 *
	 * @param sideAlpha The width of the rectangle.
	 * @param sideBravo The length of the rectangle.
	 * @param color A java awt color that the shape will be rendered in.
	 */
	public Rectangle(double sideAlpha, double sideBravo, Color color){
		super(sideAlpha, color);
		this.sideBravo = sideBravo;
		numOfRect++;
		id = numOfRect;
	}

	/**
	 * Default constructor that creates a black void Rectangle
	 */
	public Rectangle(){
		this(0,0, Color.black);
	}

	/**
	 * Calculates the area of the rectangle with user defined properties.
	 * @return The area of the rectangle
	 */
	@Override
	public double findArea() {
		return sideBravo * getSideAlpha();
	}

	/**
	 * Calculates the perimeter of the rectangle with user defined properties.
	 * @return The perimeter of the rectangle
	 */
	@Override
	public double findPerimeter() {
		return 2 * sideBravo + 2 * getSideAlpha();
	}

	/**
	 * Accessor method for the side B property, use this to get a copy of the value.
	 * @param sideBravo The value of side B
	 */
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

