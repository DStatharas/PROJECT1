package com.JavaNerds.app;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner myObj = new Scanner(System.in);
        String oneString;
        Integer oneInt = 3;
        Boolean esc = false;

        while (esc == false) {
            try {
                oneInt = myObj.nextInt();
                myObj.nextLine();
                esc = true;
            } catch (Exception e) {
                myObj.nextLine();
                esc = false;
            }
        }
    }
}
