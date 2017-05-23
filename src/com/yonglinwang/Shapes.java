package com.yonglinwang;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yonglinwang.util.InputReader;
import com.yonglinwang.util.Listener;
import com.yonglinwang.util.Prompter;

/**
 * <h1>YonglinDB</h1>
 * <pre>A comprehensive example of object-oriented programming in Java 8</pre>
 * <h2>Project Description</h2>
 * <p>
 *     YonglinDB is created for a grade 12 computer science course in Unionville High School. It resembles a temporary
 *     database which allows users to create 2-dimensional/3-dimensional shapes through inputting crucial properties. The
 *     program then inserts all the data into a private database, in which properties are only accessable through the use
 *     of built in accessor and modifier methods.
 * </p>
 * <p>
 *     The challenge of this project was seen as how to write the logic, not how to define the data. Object-oriented programming
 *     takes the view that what we really care about are the objects we want to manipulate rather than the logic required to
 *     manipulate them.
 * </p>
 * <h3>Principal</h3>
 * <p>
 *     To best utilize polymorphism, overriding, data modeling and encapsulation techniques learned in class.
 * </p>
 * <h3>Standard Features</h3>
 * <ul>
 *     <li>Encapsulation of geometric shape properties, only accessible through methods</li>
 *     <li>Class level counting properties implemented</li>
 *     <li>High variable efficiency</li>
 *     <li>Default constructors for indecisive users</li>
 *     <li>A one of a kind geometry hierarchy implemented in {@code Shapes.java}</li>
 *     <li>Easy to use, foolproof command prompt interface</li>
 * </ul>
 * <h3>Unique Features</h3>
 * <ul>
 *     <li>Robust input listener that prevents input human error</li>
 *     <li>Database status report</li>
 *     <li>Database records report</li>
 *     <li>One of a kind output tracker</li>
 *     <li>User setting and profile system</li>
 *     <li> Robust query system</li>
 *     <li>SAVE DATABASE INFORMATION ON HARD DRIVE!</li>
 * </ul>
 * Crafted by Yonglin Wang through May.
 * @version 1.2.1
 * @since JDK7.0
 */
public final class Shapes {
	/**
	 * This creates a global prompting system to allow methods to
	 * display prompts to users.
	 */
	private Prompter p = new Prompter();
	/**
	 * This creates a global listening system to allow methods to
	 * display listen to user input.
	 */
	private Listener listen = new Listener();
	/**
	 * This is the object that will be storing all the records. Declared
	 * globally so all use class methods can utilize it.
	 */
	private Database database = new Database();
	/**
	 * <pre>Assembles the use methods to form a use class</pre>
	 * <h2>Method Explanation</h2>
	 * <p>The <code>Main(String)</code> acts as the client hub for YonglinDB. It uses switch and
	 * cases to determine user command and calls the respective procedural method to execute the
	 * operation the user requested.
	 * <p>The system operates on an infinite while loop until user inputs the exit command to exit
	 * from the query system
	 * 
	 */
	public static void main(String[] args) {
		Prompter p = new Prompter();
		Listener listen = new Listener();
		Shapes local = new Shapes();

		boolean inMenu = true;

		p.type("\nHello There! Welcome to YonglinDB!\n", 50);
		p.printSpacing();
		p.print("The purpose of this Database is to use the object-oriented programming concepts discussed in ICS4U1.  \n" +
				"The system implement a series of classes that simulates geometric shapes: \n2D four sided - " +
				"square, rectangle, rhombus, parallelogram, trapezoid, kite, and 3D six faced – cube, rectangular prism. \n");
		p.print("The Database also includes methods to determine advanced properties of a geometric shape (the area, perimeter, " +
				"surface area, volume). \nThe Database is also able to keep track of the number geometric shape created, " +
				"as well as the number of each type of geometric shape created.");
		p.printSpacing();
		while (inMenu) {
			p.print("Please continue with command, if you need help type <help>");
			switch (listen.listen().toUpperCase()) {
				case "HELP":
					local.printHelp();
					break;
				case "INSERT":
					p.type("LOADING...",200);
					local.insertNewObject();
					break;
				case "LIST":
					System.out.println(local.database);
					p.printSpacing();
					break;
				case "DROP":
					local.dropDatabase();
					break;
				case "PUBLISH":
					local.publishDatabase();
					break;
				case "SEARCH":
					local.searchDatabase();
					break;
				case "SETTINGS":
					break;
				case "CREDIT":
					break;
				case "EXIT":
					inMenu = false;
					System.out.println("Thank you for using YonglinDB! Have a fantastic day!");
					break;
				default:
					p.printError("Command not recognized, please try again");
					p.printSpacing();
			}
		}
		local.listen.stop();
		listen.stop();
	}
	/**
	 * <pre>Display a list of available commands</pre>
	 * <h2>Method Explanation</h2>
	 * <p>
	 *     The {@code printHelp()} method looks for a file titled "help.txt" in the project folder.
	 *     Then displays the content of the file using the YonglinDB custom prompting toolkit.
	 * </p>
     * <h2>Local Variables</h2>
	 * <ul>
	 *     <li>[InputReader input] - the InputReader toolkit from Yonglin Utility Pack to read file.</li>
	 * </ul>
	 * @see Prompter
	 */
	private void printHelp(){
		InputReader input;

		try {
			input = new InputReader("help.txt");
			p.printSpacing();
			p.print("Here is a list of commands");
			p.printList(input.getRawListInput(),"bullet");
			p.printSpacing();
		}catch(FileNotFoundException fe){
			System.out.println("File Cannot be found");
		}catch (IOException e){
			System.out.printf("IO Exception Occurred");
		}
	}

    /**
     * <pre>Assemble the procedures of inserting a new object into the database</pre>
     * <h2>Method Explanation</h2>
     * <p>
	 *     The {@code insertNewObject(String)} method executes the procedures of creating and inserting a new record into
	 *     the YonglinDB. It achieves this through using the Listener utility and Prompter utility from the Yonglin's Utility
	 *     Kit. The system is built with robustness and simplicity in mind. Every user input is designed to be bullet proof
	 *     and secure. The method also utilizes prompts to make sure the user is able to create the shape they desire.
     * </p>
	 * <p>
	 *     After confirming the properties of the shape the user want's to create, the method requests to insert a new object
	 *     with defined characteristics into the database. In this case, it is built on the grounds of an arrayList from java
	 *     utility library.
	 * </p>
	 * <h2>Local Variables</h2>
	 * <ul>
	 *     <li>[Color color] - temporarily stores the user defined color, later used for creating the new object.</li>
	 *     <li>[double sideA] - temporarily stores the user defined side A length, later used for creating the new object.</li>
	 *     <li>[double sideB] - temporarily stores the user defined side B length, later used for creating the new object.</li>
	 *     <li>[double sideC] - temporarily stores the user defined side C length, later used for creating the new object.</li>
	 *     <li>[double sideD] - temporarily stores the user defined side D length, later used for creating the new object.</li>
	 *     <li>[double height] - temporarily stores the user defined height, later used for creating the new object.</li>
	 *     <li>[double sideLength] - temporarily stores the user defined side length, later used for creating the new object.</li>
	 * </ul>
	 * @see Database
     */
	private void insertNewObject(){
		Color color;
		double sideA, sideB, sideC, sideD, height;
		double sideLength;
		p.printSpacing();
		p.print("Welcome to Yonglin's geometry Database insertion wizard! Type anything unexpected to exit.\n");
		boolean forDefault = listen.forBooleanWithPrompt("Y","Create objects with default properties? (Y/n): ");
		forDefault = !forDefault;
		switch(listen.withPrompt("2D or 3D: ").toUpperCase()){
			case "2D":
				p.print("\nHere is a list of shapes you can create:");
				p.print("2D Shapes: ");
				p.printList("2d.txt", "number");
				p.printSpacing();
				switch(listen.withPrompt("Name or number of shape: ").toUpperCase()){
					case "SQUARE":
					case "1":
						if (forDefault) {
							do{
                                sideLength = listen.withPromptForDouble("Side Length: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side length = " + sideLength);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new Square(sideLength, color));
						}else
							database.insert(new Square());
						creationDonePrompt("square");
						break;
					case "RECTANGLE":
					case "2":
						if (forDefault) {
							do{
                                sideA = listen.withPromptForDouble("Side A: ");
                                sideB = listen.withPromptForDouble("Side B: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side A = " + sideA);
                                System.out.println("side B = " + sideB);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new Rectangle(sideA,sideB,color));
						} else {
							database.insert(new Rectangle());
						}
						creationDonePrompt("Rectangle");
						break;
					case "KITE":
					case "4":
						double diagonalQ, diagonalP;
						if (forDefault) {
							do{
                                sideA = listen.withPromptForDouble("Side A: ");
                                sideB = listen.withPromptForDouble("Side B: ");
                                diagonalQ = listen.withPromptForDouble("Diagonal Q: ");
                                diagonalP = listen.withPromptForDouble("Diagonal P: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side A = " + sideA);
                                System.out.println("diagonal P = " + diagonalP);
                                System.out.println("diagonal Q = " + diagonalQ);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new Kite(sideA,sideB,diagonalQ,diagonalP,color));
						} else {
							database.insert(new Kite());
						}
						creationDonePrompt("kite");
						break;
					case "RHOMBUS":
					case "3":
						if (forDefault) {
							do{
                                sideA = listen.withPromptForDouble("Side A: ");
                                height = listen.withPromptForDouble("Height: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side A = " + sideA);
                                System.out.println("Height = " + height);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new Rhombus(sideA,height,color));
						} else {
							database.insert(new Rhombus());
						}
						creationDonePrompt("rhombus");
						break;
					case "PARALLELOGRAM":
					case "5":
						if (forDefault) {
							do{
                                sideA = listen.withPromptForDouble("Side A: ");
                                sideB = listen.withPromptForDouble("Side B: ");
                                height = listen.withPromptForDouble("Height: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side A = " + sideA);
                                System.out.println("side B = " + sideB);
                                System.out.println("height = " + height);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new Parallelogram(sideA,sideB,height,color));
						} else {
							database.insert(new Parallelogram());
						}
						creationDonePrompt("parallelogram");
						break;
					case "ISOSCELES TRAPEZOID":
					case "6":
						if (forDefault) {
							do{
                                sideA = listen.withPromptForDouble("Side A: ");
                                sideB = listen.withPromptForDouble("Side B: ");
                                sideC = listen.withPromptForDouble("Side C: ");
                                sideD = listen.withPromptForDouble("Side D: ");
                                height = listen.withPromptForDouble("Height: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side A = " + sideA);
                                System.out.println("side B = " + sideB);
                                System.out.println("side C = " + sideC);
                                System.out.println("side D = " + sideD);
                                System.out.println("height = " + height);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new IsoscelesTrapezoid(sideA,sideB,sideC,sideD,color));
						} else {
							database.insert(new IsoscelesTrapezoid());
						}
						creationDonePrompt("isosceles trapezoid");
						break;
					default:
						System.out.println("Requested shape not recognized, returning back to home.");
				}
				break;
			case "3D":
				p.print("\nHere is a list of shapes you can create:");
				p.print("3D Shapes: ");
				p.printList("3d.txt", "number");
				p.printSpacing();
				switch(listen.withPrompt("Name or number of shape: ").toUpperCase()){
					case "CUBE":
					case "1":
						if (forDefault) {
							do{
                                sideLength = listen.withPromptForDouble("Side: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side length = " + sideLength);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new Cube(sideLength,color));
						} else {
							database.insert(new Cube());
						}
						creationDonePrompt("Cube");
						break;
					case "SQUARE BASED PRISM":
					case "2":
						if (forDefault) {
							do{
                                sideLength = listen.withPromptForDouble("Side Length: ");
                                height = listen.withPromptForDouble("Height: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side length = " + sideLength);
                                System.out.println("height = " + height);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new SquareBasedPrism(sideLength,height,color));
						} else {
							database.insert(new SquareBasedPrism());
						}
						creationDonePrompt("Square Based Prism");
						break;
					case "RECTANGULAR PRISM":
					case "3":
						if (forDefault) {
							do{
                                sideA = listen.withPromptForDouble("Width: ");
                                sideB = listen.withPromptForDouble("Length: ");
                                sideC = listen.withPromptForDouble("Height: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("width = " + sideA);
                                System.out.println("height = " + sideB);
                                System.out.println("length = " + sideC);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new RectangularPrism(sideA,sideB,sideC,color));
						} else {
							database.insert(new RectangularPrism());
						}
						creationDonePrompt("RECTANGULAR prism");
						break;
					case "REGULAR PENTAGONAL PRISM":
					case "4":
						if (forDefault) {
							do{
                                sideA = listen.withPromptForDouble("Side A: ");
                                sideB = listen.withPromptForDouble("Side B: ");
                                height = listen.withPromptForDouble("Height: ");
                                color = listen.forColor();
                                System.out.println("\nYour Input: ");
                                System.out.println("side A = " + sideA);
                                System.out.println("side B = " + sideB);
                                System.out.println("length = " + height);
                                System.out.println("color = " + color + "\n");
                            }while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
							database.insert(new RegularPentagonalPyramid(sideA,sideB,height,color));
						} else {
							database.insert(new RegularPentagonalPyramid(0,0,0,Color.BLACK));
						}
						creationDonePrompt("REGULAR PENTAGONAL PRISM");
						break;
					default:
						p.printError("Requested shape not recognized, returning back to home.");
				}
				break;
			default:
				p.printError("Requested shape not recognized, returning back to home.");
		}

		p.printSpacing();
	}

	/**
	 * <pre>Alerts user what they have created.</pre>
	 * <h2>Method explanation</h2>
	 * <p>
	 *     The {@code creationDonePrompt(String)} method informs the user they have successfully created a shape in the database,
	 *     the method first prompts what kind of shape the user created - "SQUARE", "RECTANGLE" etc. Then gets the last item in
	 *     the database and displays its information to the user
	 * </p>
	 * @param shape The name of the shape. (Such as: square)
	 */
	private void creationDonePrompt(String shape){
		p.printSpacing();
		p.print("A new " + shape.toUpperCase() + " is created, here are the details: ");
		p.print(database.get(database.size()-1).toString());
	}

	/**
	 * <pre>Removes all records from the database</pre>
	 * <h2>Method Explanation</h2>
	 * <p>
	 *     This method prompts the user to confirm that they want to remove all records from the database then proceeds if they
	 *     input the confirmation message through calling the drop method to drop all content from the database.
	 * </p>
	 */
	private void dropDatabase(){
		if(listen.withPrompt("Confirm this operation by typing <verisimilitude>").equals("verisimilitude")) {
			database.drop();
			p.print("Operation successful, database is dropped");
		}else
			p.print("Operation canceled.");
	}

	/**
	 * <pre>Searches the database for the information of a specific record</pre>
	 * <h2>Method Explanation</h2>
	 * <p>
	 *     This method operates on the fundamental query philosophy, user input the ID of the shape and the database will go search
	 *     for the object and return a String containing the information of the shape which would be prompted by this method.
	 * </p>
	 * <h2>Local Variables</h2>
	 * <ul>
	 *     <li>[String id] - User define the value of the id to be searched</li>
	 * </ul>
	 */
	private void searchDatabase(){
		p.print("Welcome to YonglinDB search wizard! Type anything unexpected to exit.\n");
		String id = listen.withPrompt("ID of object: ");
		p.printSpacing();
		p.print("Here is the result of your search query: ");
		try {
			p.print(database.search(id));
			p.printSpacing();
		} catch (Exception e) {
			p.printError("\tNo records with id - " + id + " found in database. :(");
			p.printSpacing();
		}
	}

	/**
	 * <pre>Exports the database information as a text file</pre>
	 * <h2>Method Explanation</h2>
	 * <p>
	 *     This method exports a report of the database as txt format encoded in UTF-8. The information on the report
	 *     includes the basic statistics of the database, mostly number of information. The report also includes details
	 *     of each record.
	 * </p>
	 * <p>
	 *     The method achieves this through using the class level variables provided in each object(shape) type and the
	 *     toString method used to list out all the elements in the database (the same utilized in the [list] command).
	 *     After that, the method creates a new text file if one doesn't already exist then prints all the information
	 *     line by line onto the text file.
	 * </p>
	 *
	 * <h2>Local Variables</h2>
	 * <ul>
	 *     <li>[DateFormat dateFormat] - the format of date used within printing the report.</li>
	 *     <li>[DateFormat fileNameDate] - the format of date used for the file name.</li>
	 *     <li>[Date date] - The date used to </li>
	 *     <li>[String fileName] - The fileName used to create the file.</li>
	 *     <li>[List of String records] - The records toString in the format of an arrayList.</li>
	 *     <li>[List of String lines] - Lines to be printed before the records are.</li>
	 *     <li>[Path file] - The created file.</li>
	 * </ul>
	 */
	private void publishDatabase(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DateFormat fileNameDate = new SimpleDateFormat("yyyy-MM-dd-HH_mm");
		Date date = new Date();
		String fileName = fileNameDate.format(date) + "-YonglinDB-report.txt";
		List<String> records = new ArrayList<>(Arrays.asList(database.toString().split("\n")));
		System.out.println(records);
		List<String> lines = Arrays.asList(
				"----------------------------------------------------------------",
				"|",
				"|\tYonglinDB Report",
				"|\tGenerated at - "+ dateFormat.format(date),
				"|",
				"|---------------------------------------------------------------",
				"|\tStatistics:\n", "|\tNumber of shapes: "+database.size(), "|\tNumber of 2-dimensional shapes: "+TwoDimensional.getNumOfTwoD(), "|\tNumber of 3-dimensional shapes: "+ThreeDimensional.getNumOfThreeD(), "|\tNumber of Squares: "+Square.getNumOfSquare(), "|\tNumber of Rectangles: "+Rectangle.getNumOfRectangles(), "|\tNumber of Rhombus: "+Rhombus.getNumOfRhombus(), "|\tNumber of Parallelogram: "+Parallelogram.getNumOfParallelograms(), "|\tNumber of Kite: "+Kite.getNumOfKite(), "|\tNumber of Isosceles Trapezoid: "+IsoscelesTrapezoid.getNumOfIsoscelesTrapezoid(), "|\tNumber of Cubes: "+Cube.getNumOfCubes(), "|\tNumber of Square Based Prisms: "+SquareBasedPrism.getNumOfSquareBasedPrism(), "|\tNumber of Rectangular Prism: "+RectangularPrism.getNumOfRectangularPrism(), "|\tNumber of Regular Pentagonal Pyramid:"+RegularPentagonalPyramid.getNumOfRegularPentagonalPyramid(), "|---------------------------------------------------------------",
				"","Records:", "(In created date order)");
		Path file = Paths.get(fileName);
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
			Files.write(file, records, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			p.print("Report has been generated at - " + file.getFileName().toUri().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Database extends ArrayList<Shape>{
	/**
	 * {@inheritDoc}
	 *
	 * @return A String containing all the information regarding all the instances in the database
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		for (int i = 0; i < size(); i++){
			text.append(get(i).toString()).append("\n\n");
		}
		return text.toString();
	}

	/**
	 * <pre>Query for a specific instance in the database</pre>
	 * <p>
	 *     The get method uses a simple linear search algorithm and seeks for an object with identical id as the parameter.
	 *     If an object is found, its id is changed to a new one defined in the parameter.
	 * </p>
	 * <p>
	 *     If the query goes unanswered, the method throws a no such element exception to warn the user agent about the
	 *     error.
	 * </p>
	 * @param oldID The id of the item that should be changed
	 * @param newID The new id
	 */
	public void changeID(String oldID, String newID){
		int count = 0;
		for (Shape item:this) {
			if(item.getId().equals(oldID)){
				item.setId(newID);
				System.out.println("An item has changed id from - '" + oldID + "' to - '" + newID + "'.");
				count++;
			}
		}
		if (count == 0)
			throw new NoSuchElementException();
		System.out.println("Query has been processed. " + count + "objects have changed ID.");
	}

	/**
	 * Wrapper method for {@link List#clear()}, allow more personal features to be implemented in the future.
	 * @see List
	 * @see List#clear()
	 */
	public void drop(){
		this.clear();
	}

	/**
	 * Wrapper method for {@link List#add(Object)}, allows more personal features to be implemented in the future.
	 * @param s A Shape class or any subclass of a shape class.
	 */
	public void insert(Shape s){
		this.add(s);
	}

	/**
	 * <pre>Query for a specific instance in the database</pre>
	 * <p>
	 *     The get method uses a simple linear search algorithm and seeks for an object with identical id as the parameter.
	 *     If an object is found, it is immediately returned to the user agent.
	 * </p>
	 * <p>
	 *     If the query goes unanswered, the method throws a no such element exception to warn the user agent about the
	 *     error.
	 * </p>
	 * @param id The String identification of the instance to be queried
	 * @return The object if found, if not NoSuchElementException is thrown
	 * @throws NoSuchElementException
	 */
	public Shape get(String id){
		for (Shape item:this) {
			if(item.getId().equals(id))
				return item;
		}
		throw new NoSuchElementException();
	}

	/**
	 * <pre>Query for a specific instance in the database</pre>
	 * <p>
	 *     The get method uses a simple linear search algorithm and seeks for an object with identical id as the parameter.
	 *     If an object is found, it is immediately returned to the user agent.
	 * </p>
	 * <p>
	 *     If the query goes unanswered, the method throws a no such element exception to warn the user agent about the
	 *     error.
	 * </p>
	 * @param id The String identification of the instance to be queried
	 * @return A string containing the information of the queried item
	 */
	public String search(String id){
		for (Shape item:this) {
			if(item.getId().equals(id))
				return item.toString();
		}
		throw new NoSuchElementException();
	}
}
