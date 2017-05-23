package com.yonglinwang.util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <pre>Enhance and simplify System.out.println</pre>
 * <h2>Class Explanation</h2>
 * <p>
 *     The purpose of the {@code Prompter} class is to be able to print console prompts to user elegantly without having
 *     all the clog code and hassle. The Yonglin.util Prompter class achieves this by providing a list of methods that
 *     allow different styling format of console logs.
 * </p>
 * <p>
 *     In general, Prompter takes a string and takes an option and displays the string according to the agent assigned
 *     options or the default option. In some cases, such as delay between lines of code, the Prompter uses both agent
 *     defined properties and default properties to provide the most adequate experience.
 * </p>
 * <p>
 *     Each printing method will have detailed documentation on how they function. For more information on specific
 *     functionality, please refer to the respective method.
 * </p>
 *
 * @author Yonglin Wang
 * @version 1.1
 * @since JDK7.0
 */
public class Prompter {
    /**
     * The formatting of the date.
     */
    private DateFormat dateFormat;
    /**
     * The date object used to determine the time for prompting.
     */
    private Date date;

    /**
     * Construct a Prompter with a specified date format.
     * For more information on format specifications, [click here]{@link DateFormat}.
     * @param formatOfDate String, according to dateFormat requirements.
     */
    public Prompter(String formatOfDate) {
        dateFormat = new SimpleDateFormat(formatOfDate);
    }
    /**
     * Construct a Prompter with a default date format.
     *
     * Looks like: 1999/07/29 11:44:09
     */
    public Prompter(){
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }

    /**
     * <pre>Display a prompt with a delay for better user experience</pre>
     * <h2>Method Explanation</h2>
     * <p>
     *     The method prints a line with System.out.println then pauses the thread for 100ms to create the illusion of
     *     time delay between printing so users don't get confused by quick spitting prompts. Good for cases with a lot
     *     of lines of prompt.
     * </p>
     *
     * @see System
     * @see Thread#sleep(long)
     * @param s The prompt
     */
    public void print(String s){
        System.out.println(s);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    /**
     * <pre>Prompts a dated message</pre>
     * <h2>Method Explanation</h2>
     * TODO Explain the details of the method
     * @param message The String message to be prompted
     * @param position "before" or "after" the message.
     */
    public void printWithDate(String message, String position){
        date = new Date();
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

    /**
     * <pre>Prompts the current date in predefined format to the user</pre>
     */
    public void printDate(){
        date = new Date();
        print(dateFormat.format(date));
    }

    /**
     * <pre>Animated typewriting style prompting</pre>
     * @param message The message to be printed.
     * @param delayBetweenChar The delay between characters in milliseconds.
     */
    public void type(String message, long delayBetweenChar){
        TimeUnit unit = TimeUnit.MILLISECONDS;
        for (char ch:message.toCharArray()) {
            System.out.print(ch);
            try {
                unit.sleep(delayBetweenChar);
            } catch (InterruptedException e) {
            }
        }
        System.out.print("\n");
    }

    /**
     * <pre>Prompts a line for spacing purposes</pre>
     */
    public void printSpacing(){
        System.out.println("===========================================");
    }

    /**
     * <pre>Prompts a </pre>
     * @param message
     */
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
            System.out.println("Requested file cannot be found");
        }catch (IOException e){
            System.out.printf("IO Exception Occurred");
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