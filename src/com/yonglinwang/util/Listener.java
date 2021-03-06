package com.yonglinwang.util;

/**
 * Created by Yonglin Wang on 5/7/2017.
 */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Listener {
    BufferedReader br;
    Scanner in;
    public Listener(){
        br = new BufferedReader(new InputStreamReader(System.in));
        in = new Scanner(System.in);
    }
    public String listen(){
        String temp = null;
        try {
            temp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IO Exception happened when trying to listen for input.");
        }
        return temp;
    }
    public int forInt(){
        int temp;
        while(true){
            try{
                temp = in.nextInt();
                break;
            }catch(Exception e){
                System.err.println("Please input an integer value. for example: " + ThreadLocalRandom.current().nextInt(0, 100 + 1));
                in.next();
            }
        }
        return temp;
    }
    public double forDouble(){
        double temp;
        while(true){
            if(in.hasNextDouble()){
                temp = in.nextDouble();
                break;
            }
            System.err.println("Please input a double value. eg: " + ThreadLocalRandom.current().nextDouble(0, 100 + 1));
            in.next();
        }
        return temp;
    }
    public boolean forBooleanWithPrompt(String trueStatement,String message){
        if(withPrompt(message).equals(trueStatement))
            return true;
        return false;
    }
    public void stop(){
        try {
            br.close();
        } catch (IOException e) {
            System.err.println("IO Exception happened when trying to close the BufferedReader, please close the program");
        }
        in.close();
    }
    public String withPrompt(String message){
        System.out.print(message);
        String text = in.next();
        return text;
    }
    public int withPromptForInt(String message){
        System.out.print(message);
        return forInt();
    }
    public double withPromptForDouble(String message){
        System.out.print(message);
        return forDouble();
    }
    public Color forColor(){
        Color color;
        try {
            Field field = Class.forName("java.awt.Color").getField(withPrompt("Color: "));
            color = (Color)field.get(null);
        } catch (Exception e) {
            System.err.println("This color does not exist in the color space. Color is set to null.");
            color = null; // Not defined
        }
        return color;
    }
}
