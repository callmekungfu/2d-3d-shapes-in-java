package com.yonglinwang;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.yonglinwang.util.InputReader;
import com.yonglinwang.util.Listening;
import com.yonglinwang.util.Prompting;

/**
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
	 * <h2>Method Explaination</h2>
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
				case "PRINT":
					break;
				case "SETTINGS":
					break;
				case "ADMIN":
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
		p.printSpacing();
		p.print("Welcome to Yonglin's geometry Database insertion wizard!\n");
		switch(listen.withPrompt("2D or 3D: ").toUpperCase()){
			case "2D":
				p.print("Here is a list of shapes you can create:");
				p.print("2D Shapes: ");
				p.printList("C:\\Users\\Yonglin Wang\\Documents\\GitHub\\2d-3d-shapes-in-java\\2d.txt", "number");
				switch(listen.withPrompt("Name or number of shape: ").toUpperCase()){
					case "SQUARE":
					case "1":
						database.add(new Square(listen.withPromptForDouble("Side Length: "), Color.black));
						creationDonePrompt("square");
						break;
					case "RECTANGLE":
					case "2":
						database.add(new Rectangle(listen.withPromptForDouble("Side A Length: "),listen.withPromptForDouble("Side B Length: "),Color.BLACK));
						creationDonePrompt("Rectangle");
						break;
					case "KITE":
					case "4":
						database.add(new Kite(listen.withPromptForDouble("Side A Length: "),listen.withPromptForDouble("Side B Length: "),listen.withPromptForDouble("Diagonal Q Length: "),listen.withPromptForDouble("Diagonal P Length: "),Color.magenta));
						creationDonePrompt("kite");
						break;
					case "RHOMBUS":
					case "3":
						database.add(new Rhombus(listen.withPromptForDouble("Side A Length: "),listen.withPromptForDouble("Height: "),Color.BLACK));
						creationDonePrompt("rhombus");
						break;
					case "PARALLELOGRAM":
					case "5":
						database.add(new Parallelogram(listen.withPromptForDouble("Side A Length: "),listen.withPromptForDouble("Side B Length: "),listen.withPromptForDouble("Height: "),Color.magenta));
						creationDonePrompt("parallelogram");
						break;
					case "ISOSCELES TRAPEZOID":
					case "6":
						database.add(new IsoscelesTrapezoid(listen.withPromptForDouble("Side A Length: "),listen.withPromptForDouble("Side B Length: "),listen.withPromptForDouble("Side C Length: "),listen.withPromptForDouble("Height: "),Color.magenta));
						creationDonePrompt("isosceles trapezoid");
						break;
					default:
						System.out.println("Requested shape not recognized, returning back to home.");
				}
				break;
			case "3D":
				p.print("Here is a list of shapes you can create:");
				p.print("3D Shapes: ");
				p.printList("C:\\Users\\Yonglin Wang\\Documents\\GitHub\\2d-3d-shapes-in-java\\3d.txt", "number");
				switch(listen.withPrompt("Name or number of shape: ").toUpperCase()){
					case "CUBE":
					case "1":
						database.add(new Cube(listen.withPromptForDouble("Side Length: "),Color.magenta));
						creationDonePrompt("Cube");
						break;
					case "SQUARE BASED PRISM":
					case "2":
						database.add(new SquareBasedPrism(listen.withPromptForDouble("Side Length: "),listen.withPromptForDouble("Height: "),Color.magenta));
						creationDonePrompt("Square Based Prism");
						break;
					case "RECTANGULAR PRISM":
					case "3":
						database.add(new RectangularPrism(listen.withPromptForDouble("Width: "),listen.withPromptForDouble("Length: "),listen.withPromptForDouble("Height: "),Color.magenta));
						creationDonePrompt("RECTANGULAR prism");
						break;
					case "REGULAR PENTAGONAL PRISM":
					case "4":
						database.add(new RegularPentagonalPyramid(listen.withPromptForDouble("Side A: "),listen.withPromptForDouble("Side B: "),listen.withPromptForDouble("Height: "),Color.magenta));
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

class Database extends ArrayList<? extends Shape>{
	@Override
	public String toString() {
		String text = "";
		for (int i = 0; i < size(); i++){
			text += get(i).toString() + "\n\n";
		}
		return text;
	}
}

