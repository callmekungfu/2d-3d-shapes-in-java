package com.yonglinwang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("hello intellij");
        String test = br.readLine();
        System.out.println(test);
        System.out.println("test = " + test);
    }
}
