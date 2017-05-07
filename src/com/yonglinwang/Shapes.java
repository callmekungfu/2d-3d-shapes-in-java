package com.yonglinwang;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.yonglinwang.util.InputReader;
import com.yonglinwang.util.Listening;
import com.yonglinwang.util.Prompting;

/**
 * Created by Yonglin Wang on 4/19/2017.
 */
public final class Shapes {
	Prompting p = new Prompting();
	Listening listen = new Listening();
	List<Shape> database = new ArrayList<>();
	public static void main(String[] args) {
		Prompting p = new Prompting();
		Listening listen = new Listening();
		Shapes local = new Shapes();
		p.type("\nHello There! Welcome to yonglinDB!\n\n", 50);
		p.printSpacing();
		p.print("The purpose of this database is to use the object-oriented programming concepts discussed in ICS4U1.  \n" +
				"The system implement a series of classes that simulates geometric shapes: \n2D four sided - " +
				"square, rectangle, rhombus, parallelogram, trapezoid, kite, and 3D six faced – cube, rectangular prism. \n");
		p.print("The database also includes methods to determine advanced properties of a geometric shape (the area, perimeter, " +
				"surface area, volume). \nThe database is also able to keep track of the number geometric shape created, " +
				"as well as the number of each type of geometric shape created.");
		p.printSpacing();
		while (true) {
			p.print("Please continue with command, if you need help type <help>");
			String command = listen.listen();
			String selector = command.toUpperCase();
			switch (selector) {
				case "HELP":
					local.printHelp();
					break;
				case "INSERT":
					p.type("LOADING...",200);
					local.createNewObject(command);
					break;
				case "LIST":
					break;
				case "DROP":
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
					break;
				default:
					p.printError("Command not recognized, please try again");
					p.printSpacing();
			}
		}

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
	private void createNewObject(String command){
		p.printSpacing();
		p.print("Welcome to Yonglin's geometry database insertion wizard!\n");
		switch(listen.withPrompt("2D or 3D: ", "string").toUpperCase()){
			case "2D":
				p.print("Here is a list of shapes you can create:");
				p.print("2D Shapes: ");
				p.printList("C:\\Users\\Yonglin Wang\\Documents\\GitHub\\2d-3d-shapes-in-java\\2d.txt", "number");
				switch(listen.withPrompt("Name or number of shape: ", "string").toUpperCase()){
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
			case "3D":
				p.print("Here is a list of shapes you can create:");
				p.print("3D Shapes: ");
				p.printList("C:\\Users\\Yonglin Wang\\Documents\\GitHub\\2d-3d-shapes-in-java\\3d.txt", "number");
				switch(listen.withPrompt("Name or number of shape: ", "string").toUpperCase()){
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
		}


		p.printSpacing();
	}
	private void creationDonePrompt(String shape){
		p.printSpacing();
		p.print("A new " + shape.toUpperCase() + " is created, here are the details: ");
		p.print(database.get(database.size()-1).toString());
	}
}



