package com.JavaNerds.app;

import java.io.IOException;

public abstract class projectTools {

    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void dotLoading(String indication, Integer iterations) throws InterruptedException  {
        for (int i = 0; i < iterations; i++) {
            clearConsole();
            System.out.print(indication);
            for (int j = 0; j < 3; j++) {
                Thread.sleep(150);
                System.out.print(".");
                Thread.sleep(150);
            }
        }
        clearConsole();
    }

    public static void propellerLoading(String indication, Integer rotations) throws InterruptedException {
        for (int i = 0; i < rotations; i++) {
            clearConsole();
            System.out.print(indication+" ");
            System.out.println("|");
            Thread.sleep(150);
            clearConsole();
            System.out.print(indication+" ");
            System.out.println("/");
            Thread.sleep(150);
            clearConsole();
            System.out.print(indication+" ");
            System.out.println("-");
            Thread.sleep(150);
            clearConsole();
            System.out.print(indication+" ");
            System.out.println("\\");
            Thread.sleep(150);
        }
        clearConsole();
    }

    public static void flasher(String flashable, Integer flashes, Integer flashingInterval) throws InterruptedException {
        for (int i = 0; i < flashes; i++) {
            clearConsole();
            System.out.println(flashable);
            Thread.sleep(flashingInterval);
            clearConsole();
            Thread.sleep(flashingInterval);
        }
    }

    public static void colorFlasher(String flashable, Integer flashes, Integer flashingInterval, String color1) throws InterruptedException {
        for (int i = 0; i < flashes; i++) {
            clearConsole();
            System.out.print(color1);
            System.out.println(flashable);
            Thread.sleep(flashingInterval);
            clearConsole();
            Thread.sleep(flashingInterval);
        }

        clearConsole();
        ConsoleColors.reset();
    }

    public static void colorFlasher(String flashable, Integer flashes, Integer flashingInterval, String color1, String color2) throws InterruptedException {
        for (int i = 0; i < flashes; i++) {
            clearConsole();
            System.out.print(color1);
            System.out.println(flashable);
            Thread.sleep(flashingInterval);
            clearConsole();
            System.out.print(color2);
            System.out.println(flashable);
            Thread.sleep(flashingInterval);
            ConsoleColors.reset();
        }

        clearConsole();
    }
}
