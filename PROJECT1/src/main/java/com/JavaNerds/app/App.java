package com.JavaNerds.app;

import java.util.Scanner;

public class App

{
    public static void main( String[] args ) throws InterruptedException
    {   
        Admin mainAdminInstance = new Admin();

        String inputChecker = null;
        Integer intChecker = null;
        Scanner oneScanner = new Scanner(System.in);

        mloop:
        while (true) {
            inputChecker = null;
            intChecker = null;
            projectTools.clearConsole();
            System.out.println("\u001B[32m" + "\n========== All parametric data files updated successfully ==========" + "\u001B[0m" + "\n");
            System.out.println("Welcome to Virtual Manager 2024: Cluster Boogaloo!\n");
            System.out.println(mainAdminInstance.reportCluster());
            mainAdminInstance.displayVmArray();
            System.out.println("\n-----------------------------------------"+"\n\n");
            System.out.println("Please select one of the following options:\n");
            System.out.println("1: Create new Virtual Machine\n2: Update an existing Virtual Machine\n3: Delete a Virtual Machine\n4: Receive a report on a Virtual Machine's available resources\n0: Terminate Application\n");
            System.out.print("Select option: ");
            try {
                intChecker = Integer.parseInt(oneScanner.next());
                projectTools.clearConsole();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                Thread.sleep(3000);
                continue;
            }
                

            switch (intChecker) {
                case 0:
                    inputChecker = null;
                    System.out.print("Are you sure you want to quit? All unsaved changes will be lost!\nY/N: ");
                    try {
                        inputChecker = oneScanner.next();
                        oneScanner.nextLine();
                    } catch (Exception e) {
                        continue;
                    }
                    if (inputChecker.equalsIgnoreCase("y")) {
                        projectTools.propellerLoading("\n\n   Terminating Application..." , 10);
                        break mloop;
                    }
                    else {
                        continue;
                    }
                
                case 1:
                    mainAdminInstance.createVM();
                    break;

                case 2:
                    mainAdminInstance.updateResources();
                    break;
                    
                case 3:
                    mainAdminInstance.deleteVm();
                    break;
                    
                case 4:
                    mainAdminInstance.reportVm();
                    break;
                    
                default:
                    projectTools.clearConsole();
                    System.out.println();
                    continue;
            }
        }
    }
}
