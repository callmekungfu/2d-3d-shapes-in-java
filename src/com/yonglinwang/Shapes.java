package com.yonglinwang;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.yonglinwang.util.InputReader;
import com.yonglinwang.util.Listening;
import com.yonglinwang.util.Prompting;

/**
 * 
 * Crafted by Yonglin Wang through May.
 */
public final class Shapes {
	/**
	 * This creates a global prompting system to allow methods to
	 * display prompts to users.
	 */
	private Prompting p = new Prompting();
	/**
	 * This creates a global listening system to allow methods to
	 * display listen to user input.
	 */
	private Listening listen = new Listening();
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
		Prompting p = new Prompting();
		Listening listen = new Listening();
		Shapes local = new Shapes();

		boolean inMenu = true;

		p.type("\nHello There! Welcome to yonglinDB!\n\n", 50);
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
					local.createNewObject();
					break;
				case "LIST":
					System.out.println(local.database);
					p.printSpacing();
					break;
				case "DROP":
					local.dropDatabase();
					break;
				case "PUBLISH":
					break;
				case "SEARCH":
					break;
				case "SETTINGS":
					break;
				case "CREDIT":
					break;
				case "EXIT":
					inMenu = false;
					// TODO add save operation method
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
	 * <p>The <code>Main(String)</code> acts as the client hub for YonglinDB. It uses switch and
	 * cases to determine user command and calls the respective procedural method to execute the
	 * operation the user requested.
	 * <p>The system operates on an infinite while loop until user inputs the exit command to exit
	 * from the query system
	 *
	 */
	private void printHelp(){
		InputReader input;
		try {
			input = new InputReader("C:\\Users\\Yonglin Wang\\Documents\\GitHub\\2d-3d-shapes-in-java\\help.txt");
			p.printSpacing();
			p.print("Here is a list of commands");
			p.printList(input.getRawListInput(),"bullet");
			p.printSpacing();
		}catch(FileNotFoundException fe){
			System.out.println("File Cannot be found");
		}catch (IOException e){
			System.out.printf("IO Exception Occured");
		}
	}
	private void createNewObject(){
		Color color;
		double sideA, sideB, sideC, sideD, height;
		double sideLength;
		p.printSpacing();
		p.print("Welcome to Yonglin's geometry Database insertion wizard! Type anything unexpected to exit.\n");
		switch(listen.withPrompt("2D or 3D: ").toUpperCase()){
			case "2D":
				p.print("\nHere is a list of shapes you can create:");
				p.print("2D Shapes: ");
				p.printList("C:\\Users\\Yonglin Wang\\Documents\\GitHub\\2d-3d-shapes-in-java\\2d.txt", "number");
				p.printSpacing();
				switch(listen.withPrompt("Name or number of shape: ").toUpperCase()){
					case "SQUARE":
					case "1":
						do{
							sideLength = listen.withPromptForDouble("Side Length: ");
							color = listen.forColor();
							System.out.println("\nYour Input: ");
							System.out.println("side length = " + sideLength);
							System.out.println("color = " + color + "\n");
						}while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
						database.add(new Square(sideLength, color));
						creationDonePrompt("square");
						break;
					case "RECTANGLE":
					case "2":
						do{
							sideA = listen.withPromptForDouble("Side A: ");
							sideB = listen.withPromptForDouble("Side B: ");
							color = listen.forColor();
							System.out.println("\nYour Input: ");
							System.out.println("side A = " + sideA);
							System.out.println("side B = " + sideB);
							System.out.println("color = " + color + "\n");
						}while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
						database.add(new Rectangle(sideA,sideB,color));
						creationDonePrompt("Rectangle");
						break;
					case "KITE":
					case "4":
						double diagonalQ, diagonalP;
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
						database.add(new Kite(sideA,sideB,diagonalQ,diagonalP,color));
						creationDonePrompt("kite");
						break;
					case "RHOMBUS":
					case "3":
						do{
							sideA = listen.withPromptForDouble("Side A: ");
							height = listen.withPromptForDouble("Height: ");
							color = listen.forColor();
							System.out.println("\nYour Input: ");
							System.out.println("side A = " + sideA);
							System.out.println("Height = " + height);
							System.out.println("color = " + color + "\n");
						}while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
						database.add(new Rhombus(sideA,height,color));
						creationDonePrompt("rhombus");
						break;
					case "PARALLELOGRAM":
					case "5":
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
						database.add(new Parallelogram(sideA,sideB,height,color));
						creationDonePrompt("parallelogram");
						break;
					case "ISOSCELES TRAPEZOID":
					case "6":
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
						database.add(new IsoscelesTrapezoid(sideA,sideB,sideC,sideD,color));
						creationDonePrompt("isosceles trapezoid");
						break;
					default:
						System.out.println("Requested shape not recognized, returning back to home.");
				}
				break;
			case "3D":
				p.print("\nHere is a list of shapes you can create:");
				p.print("3D Shapes: ");
				p.printList("C:\\Users\\Yonglin Wang\\Documents\\GitHub\\2d-3d-shapes-in-java\\3d.txt", "number");
				p.printSpacing();
				switch(listen.withPrompt("Name or number of shape: ").toUpperCase()){
					case "CUBE":
					case "1":
						do{
							sideLength = listen.withPromptForDouble("Side: ");
							color = listen.forColor();
							System.out.println("\nYour Input: ");
							System.out.println("side length = " + sideLength);
							System.out.println("color = " + color + "\n");
						}while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
						database.add(new Cube(sideLength,color));
						creationDonePrompt("Cube");
						break;
					case "SQUARE BASED PRISM":
					case "2":
						do{
							sideLength = listen.withPromptForDouble("Side Length: ");
							height = listen.withPromptForDouble("Height: ");
							color = listen.forColor();
							System.out.println("\nYour Input: ");
							System.out.println("side length = " + sideLength);
							System.out.println("height = " + height);
							System.out.println("color = " + color + "\n");
						}while(!listen.withPrompt("Confirm? (Y/n) ").equals("Y"));
						database.add(new SquareBasedPrism(sideLength,height,color));
						creationDonePrompt("Square Based Prism");
						break;
					case "RECTANGULAR PRISM":
					case "3":
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
						database.add(new RectangularPrism(sideA,sideB,sideC,color));
						creationDonePrompt("RECTANGULAR prism");
						break;
					case "REGULAR PENTAGONAL PRISM":
					case "4":
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
						database.add(new RegularPentagonalPyramid(sideA,sideB,height,color));
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
	private void creationDonePrompt(String shape){
		p.printSpacing();
		p.print("A new " + shape.toUpperCase() + " is created, here are the details: ");
		p.print(database.get(database.size()-1).toString());
	}
	private void dropDatabase(){
		if(listen.withPrompt("Confirm this operation by typing <verisimilitude>").equals("verisimilitude")) {
			database.clear();
			p.print("Operation successful, database is dropped");
		}else
			p.print("Operation canceled.");
	}
}

class Database extends ArrayList<Shape>{
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		for (int i = 0; i < size(); i++){
			text.append(get(i).toString()).append("\n\n");
		}
		return text.toString();
	}
}

