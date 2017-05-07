package com.yonglinwang.util;

/**
 * Created by Yonglin Wang on 5/5/2017.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Prompting{
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
    public void printWithDate(String message, String position){
        if(position.equalsIgnoreCase("before"))
            System.out.println(message + " --- " + dateFormat.format(date));
        else if(position.equalsIgnoreCase("after"))
            System.out.println(dateFormat.format(date) + " --- " + message);
        else
            System.out.println(dateFormat.format(date) + " --- " + message);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
    public void printDate(){
        System.out.println(dateFormat.format(date));
    }
    public void type(String message, long delay){
        TimeUnit unit = TimeUnit.MILLISECONDS;
        for (char ch:message.toCharArray()) {
            System.out.print(ch);
            try {
                unit.sleep(delay);
            } catch (InterruptedException e) {
                System.err.println("Process Inturupted, Returning");
            }
        }
        System.out.print("\n");
    }
    public void printSpacing(){
        System.out.println("===========================================");
    }
    public void printError(String message){
        System.err.println(message);
    }
    public void printList(List<String> list, String style){
        style = style.toUpperCase();
        switch(style){
            case "BULLET":
                for (int i = 0; i < list.size(); i++){
                    System.out.println("\t-\t" + list.get(i));
                }
                break;
            case "NUMBER":
                for (int i = 0; i < list.size(); i++){
                    System.out.println("\t" + (i+1) + "\t" + list.get(i));
                }
                break;
            default:
                for (int i = 0; i < list.size(); i++){
                    System.out.println("\t-\t" + list.get(i));
                }
        }
    }
    public void printList(String fileLocation, String style){
        InputReader input;
        try {
            input = new InputReader(fileLocation);
            printList(input.getRawListInput(),style);
        }catch(FileNotFoundException fe){
            System.out.println("File Cannot be found");
        }catch (IOException e){
            System.out.printf("IO Exception Occured");
        }
    }
    public static void log(String prompt){
        DateFormat dateFormat;
        Date date;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        System.out.println(dateFormat.format(date) + " --- " + prompt);
    }
}