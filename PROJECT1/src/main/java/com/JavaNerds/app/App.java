package com.JavaNerds.app;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Integer x = null;
        // while (true) {
        //     Scanner myScanner = new Scanner(System.in);
        //     Integer i;
        //     Integer g;
        //     Integer d;
        //     try {
        //         System.out.println("Input");
        //         i = myScanner.nextInt();
        //         myScanner.nextLine();
        //         g = myScanner.nextInt();
        //         myScanner.nextLine();
        //         d = myScanner.nextInt();
        //         myScanner.nextLine();
        //     } catch (Exception e) {
        //         System.out.println("ERROR: Invalid input!");
        //         myScanner.nextLine();
        //         continue;
        //     }
        //     System.out.println("othercode");
        //}

        try {
            System.out.println(x);
            System.out.println("success"+x);
        } catch (Exception e) {
            System.out.println("fail"+x);
        }
    }
}
