package com.yonglinwang;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yonglin Wang on 4/19/2017.
 */
public class Shapes {
	public static void main(String[] args) {
		Prompting p = new Prompting();
		p.type("Hello World", TimeUnit.MILLISECONDS, 100);
	}
}

class Prompting{
	private DateFormat dateFormat;
	private Date date;

	public Prompting(String s) {
		dateFormat = new SimpleDateFormat();
		date = new Date();
	}

	public Prompting(){
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date = new Date();
	}

	public void print(String s){
		System.out.println(s);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
	public void printWithDate(String s, String position){
		if(position.equalsIgnoreCase("before"))
			System.out.println(s + " --- " + dateFormat.format(date));
		else if(position.equalsIgnoreCase("after"))
			System.out.println(dateFormat.format(date) + " --- " + s);
		else 
			System.out.println(dateFormat.format(date) + " --- " + s);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
	public void printDate(){
		System.out.println(dateFormat.format(date));
	}
	public void type(String data, TimeUnit unit, long delay){
		for (char ch:data.toCharArray()) {
			System.out.print(ch);
			try {
				unit.sleep(delay);
			} catch (InterruptedException e) {
				System.err.println("Process Inturupted, Returning");
			}
		}
	}
}

